// 1. Create three threads with different sleep-times from the main thread with following capabilities.
//  One thread generates prime numbers in an infinite loop. Supply the sleep time of main 
// thread and the sleep time of prime thread from the command line.
//  Two more threads T1 and T2 doing any other work also execute simultaneously with 
// suitable display information. 
//  When prime thread prints 13, after that T1 goes into wait mode. T1 resumes back when 
// prime thread prints 79. 
// Threads T1 and T2 should stop executing when the keys ‘1’ and ‘2’ are pressed 
// respectively. Prime thread should stop after the ‘ENTER’ key is pressed. Exit of each 
// thread must be displayed on the console.import java.util.Scanner
import java.util.Scanner;

class PrimeThread implements Runnable {
    public final long threadSleepTime;
    private volatile boolean stopThread = false;
    private volatile boolean t1Wait = false;

    public PrimeThread(long threadSleepTime) {
        this.threadSleepTime = threadSleepTime;
    }

    @Override
    public void run() {
        int num = 2;
        while (!stopThread) {
            if (isPrime(num)) {
                System.out.println("Prime: " + num);
                if (num == 13) {
                    t1Wait = true;  // Indicate to T1 to wait
                    System.out.println("Prime thread printed 13, T1 going into wait mode...");
                    while (t1Wait) {
                        try {
                            Thread.sleep(100);  // Simulate T1 waiting
                        } catch (InterruptedException e) {
                            System.out.println("Prime thread interrupted during wait");
                        }
                    }
                } else if (num == 79) {
                    t1Wait = false;  // Resume T1
                    System.out.println("Prime thread printed 79, T1 resumes.");
                }
            }
            num++;
            try {
                Thread.sleep(threadSleepTime);
            } catch (InterruptedException e) {
                System.out.println("Prime thread interrupted.");
            }
        }
        System.out.println("Prime thread finished.");
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void stopThread() {
        stopThread = true;
    }
}

class T1Thread implements Runnable {
    private volatile boolean stopThread = false;

    @Override
    public void run() {
        while (!stopThread) {
            System.out.println("T1 is doing some work...");
            try {
                Thread.sleep(1000);  // Simulating work
            } catch (InterruptedException e) {
                System.out.println("T1 thread interrupted.");
            }
        }
        System.out.println("T1 thread finished.");
    }

    public void stopThread() {
        stopThread = true;
    }
}

class T2Thread implements Runnable {
    private volatile boolean stopThread = false;

    @Override
    public void run() {
        while (!stopThread) {
            System.out.println("T2 is doing some work...");
            try {
                Thread.sleep(1500);  // Simulating work
            } catch (InterruptedException e) {
                System.out.println("T2 thread interrupted.");
            }
        }
        System.out.println("T2 thread finished.");
    }

    public void stopThread() {
        stopThread = true;
    }
}

public class MainThread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get sleep times for prime thread and main thread
        System.out.print("Enter the sleep time for prime thread (in milliseconds): ");
        long primeSleepTime = sc.nextLong();

        System.out.print("Enter the sleep time for main thread (in milliseconds): ");
        long mainSleepTime = sc.nextLong();

        // Create the prime thread
        PrimeThread primeThread = new PrimeThread(primeSleepTime);
        Thread primeThreadObj = new Thread(primeThread);
        primeThreadObj.start();

        // Create threads T1 and T2
        T1Thread t1Thread = new T1Thread();
        Thread t1 = new Thread(t1Thread);
        t1.start();

        T2Thread t2Thread = new T2Thread();
        Thread t2 = new Thread(t2Thread);
        t2.start();

        // Key input thread to control T1, T2, and prime thread termination
        Thread keyInputThread = new Thread(() -> {
            while (true) {
                int key = sc.nextInt();
                if (key == 1) {
                    t1Thread.stopThread();  // Stop T1
                    break;
                }
                if (key == 2) {
                    t2Thread.stopThread();  // Stop T2
                    break;
                }
                if (key == 0) {
                    primeThread.stopThread();  // Stop prime thread
                    break;
                }
            }
        });
        keyInputThread.start();

        // Wait for all threads to finish
        try {
            primeThreadObj.join();  // Wait for the prime thread to finish
            t1.join();               // Wait for T1 to finish
            t2.join();               // Wait for T2 to finish
            keyInputThread.join();   // Wait for the key input thread to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread finished.");
    }
}