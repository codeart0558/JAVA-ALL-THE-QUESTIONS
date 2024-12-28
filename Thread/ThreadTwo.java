// 2. Write a program for restaurant. Use Inter Thread Communication.
//  When customer places an order then and only then Manager can take the Order or 
// generate a bill of an Order. 
//  And display the customer order after it place the Order. 
//  You have to display minimum three orders of three different customers A, B and C, in 
// which customer A is the preferred customer with higher priority.

class Restaurant {
    private String order;
    private boolean orderPlaced = false; // To track if an order is placed

    // Method to place an order
    public synchronized void placeOrder(String customerName, String orderDetails) {
        while (orderPlaced) { // Wait if an order has already been placed
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        order = orderDetails; // Set the order details
        System.out.println(customerName + " has placed the order: " + orderDetails);
        orderPlaced = true; // Mark the order as placed
        notify(); // Notify the manager that the order is ready to be taken
    }

    // Method for the manager to take the order and generate the bill
    public synchronized void takeOrderAndGenerateBill() {
        while (!orderPlaced) { // Wait until an order is placed
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("Manager is processing the order: " + order);
        System.out.println("Generating bill for the order: " + order);
        orderPlaced = false; // Reset the order status
        notify(); // Notify the customer that the order is processed
    }
}

class Customer extends Thread {
    private final Restaurant restaurant;
    private final String customerName;
    private final String orderDetails;

    public Customer(Restaurant restaurant, String customerName, String orderDetails) {
        this.restaurant = restaurant;
        this.customerName = customerName;
        this.orderDetails = orderDetails;
    }

    @Override
    public void run() {
        try {
            // Place the order
            restaurant.placeOrder(customerName, orderDetails);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Manager extends Thread {
    private final Restaurant restaurant;

    public Manager(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            // Wait for orders and generate bills
            for (int i = 0; i < 3; i++) {
                restaurant.takeOrderAndGenerateBill();
                Thread.sleep(1000); // Simulate time to process the order
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        // Create Manager thread
        Manager manager = new Manager(restaurant);
        manager.start();

        // Create Customer threads with different orders and priorities
        Customer customerA = new Customer(restaurant, "Customer A", "Burger and Fries");
        customerA.setPriority(Thread.MAX_PRIORITY); // Customer A has the highest priority
        customerA.start();

        Customer customerB = new Customer(restaurant, "Customer B", "Pizza");
        customerB.setPriority(Thread.NORM_PRIORITY);
        customerB.start();

        Customer customerC = new Customer(restaurant, "Customer C", "Pasta");
        customerC.setPriority(Thread.MIN_PRIORITY); // Customer C has the lowest priority
        customerC.start();
    }
}
