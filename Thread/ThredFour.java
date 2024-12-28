// 4. Create a class ‘Account’ with private data like accountnumber, name, balance and method 
// transaction() which handles withdraws and deposits with suitable display messages. 
//  Create a thread class ‘Teller’ with private data like name, an object of class Account, 
// amount of transaction and transaction code (deposit or withdrawal). 
//  Initiate 2 teller transactions for customer A. 
//  Also initiate two separate transaction for customer B and customer C. 
//  Transactions for one customer must run in synchronization. 
//  Transactions for different customers do not interfere with one another.

class Account {
    private String accountNumber;
    private String name;
    private double balance;

    public Account(String accountNumber, String name, double initialBalance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = initialBalance;
    }

    // Synchronized method to handle transactions (withdraw and deposit)
    public synchronized void transaction(double amount, String transactionCode) {
        if (transactionCode.equals("withdraw")) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println(name + " (Account " + accountNumber + "): Withdrawn " + amount + ". New balance: " + balance);
            } else {
                System.out.println(name + " (Account " + accountNumber + "): Insufficient funds for withdrawal of " + amount);
            }
        } else if (transactionCode.equals("deposit")) {
            balance += amount;
            System.out.println(name + " (Account " + accountNumber + "): Deposited " + amount + ". New balance: " + balance);
        }
    }
}

class Teller implements Runnable {
    private Account account;
    private double amount;
    private String transactionCode;

    public Teller(Account account, double amount, String transactionCode) {
        this.account = account;
        this.amount = amount;
        this.transactionCode = transactionCode;
    }

    @Override
    public void run() {
        account.transaction(amount, transactionCode); // Call the synchronized transaction method
    }
}

public class Main {
    public static void main(String[] args) {
        // Create accounts for customers A, B, and C
        Account accountA = new Account("A001", "Customer A", 1000);
        Account accountB = new Account("B001", "Customer B", 1500);
        Account accountC = new Account("C001", "Customer C", 2000);

        // Create Teller threads for Customer A's transactions
        Thread threadA1 = new Thread(new Teller(accountA, 500, "withdraw"));
        Thread threadA2 = new Thread(new Teller(accountA, 200, "deposit"));

        // Create Teller threads for Customer B's transactions
        Thread threadB1 = new Thread(new Teller(accountB, 300, "deposit"));
        Thread threadB2 = new Thread(new Teller(accountB, 100, "withdraw"));

        // Create Teller threads for Customer C's transactions
        Thread threadC1 = new Thread(new Teller(accountC, 600, "withdraw"));
        Thread threadC2 = new Thread(new Teller(accountC, 400, "deposit"));

        // Start Customer A's transactions (synchronized transactions for the same customer)
        threadA1.start();
        threadA1.join(); // Wait for threadA1 to finish
        threadA2.start();
        threadA2.join(); // Wait for threadA2 to finish

        // Start Customer B's transactions (synchronized transactions for the same customer)
        threadB1.start();
        threadB1.join(); // Wait for threadB1 to finish
        threadB2.start();
        threadB2.join(); // Wait for threadB2 to finish

        // Start Customer C's transactions (synchronized transactions for the same customer)
        threadC1.start();
        threadC1.join(); // Wait for threadC1 to finish
        threadC2.start();
        threadC2.join(); // Wait for threadC2 to finish

        System.out.println("All transactions have been processed.");
    }
}
