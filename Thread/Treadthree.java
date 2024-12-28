// 3. Implement three classes: Storage, Counter, and Printer. 
//  The Storage class should store an integer. 
//  The Counter class should create a thread that starts counting from 0 (0, 1, 2, 3 ...) and 
// stores each value in the Storage class. 
//  The Printer class should create a thread that keeps reading the value in the Storage class 
// and printing it.
//  Write a program that creates an instance of the Storage class and sets up a Counter and 
// a Printer object to operate on it. Ensure that each number is printed exactly once, by 
// adding suitable synchronization
class Storage {
    private int number;  // This will store the number

    // Synchronized method to set the number
    public synchronized void setNumber(int number) {
        this.number = number;
    }

    // Synchronized method to get the number
    public synchronized int getNumber() {
        return this.number;
    }
}

class Counter implements Runnable {
    private Storage storage;
    private volatile boolean stop = false;

    public Counter(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        while (!stop) {
            storage.setNumber(num);  // Store the number in Storage
            System.out.println("Counter: " + num);
            num++;
            try {
                Thread.sleep(1000);  // Simulating some delay between counting
            } catch (InterruptedException e) {
                System.out.println("Counter thread interrupted.");
            }
        }
    }

    // Method to stop the Counter thread
    public void stopCounter() {
        stop = true;
    }
}

class Printer implements Runnable {
    private Storage storage;

    public Printer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int lastPrinted = -1;  // Variable to track the last printed number
        while (true) {
            int currentNumber = storage.getNumber();  // Get the current number from Storage
            if (currentNumber != lastPrinted) {
                System.out.println("Printer: " + currentNumber);
                lastPrinted = currentNumber;  // Update last printed number
            }
            try {
                Thread.sleep(500);  // Simulate a small delay before printing the next number
            } catch (InterruptedException e) {
                System.out.println("Printer thread interrupted.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();

        // Create the Counter and Printer threads
        Counter counter = new Counter(storage);
        Printer printer = new Printer(storage);

        // Start the threads
        Thread counterThread = new Thread(counter);
        Thread printerThread = new Thread(printer);

        counterThread.start();
        printerThread.start();

        try {
            // Run the threads for a few seconds
            Thread.sleep(10000);  // Run the threads for 10 seconds (you can adjust the duration)
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // Stop the counter thread
        counter.stopCounter();
        System.out.println("Counter stopped.");

        // You may want to stop the Printer thread after some time, or leave it running if needed
        printerThread.interrupt();  // Optionally interrupt the Printer thread if you want to stop it after the Counter stops
        System.out.println("Printer stopped.");
    }
}
