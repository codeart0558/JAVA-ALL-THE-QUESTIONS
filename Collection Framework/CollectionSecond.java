// # 2. Create a HashSet of 5 names. Write a menu driven program to do the following:
// # a. Add a new name
// # b. Remove a name
// # c. Search a name
// # d. Display all the names (display in reverser order also – use ListIterator )
// # e. Display number of elements in hashset
import java.util.*;

public class CollectionSecond {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        
        // Initializing HashSet with 5 names
        set.add("drashti");
        set.add("patoliya");
        set.add("alice");
        set.add("bob");
        set.add("charlie");

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new name");
            System.out.println("2. Remove a name");
            System.out.println("3. Search for a name");
            System.out.println("4. Display all names (reverse order also)");
            System.out.println("5. Display number of elements");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter a name to add: ");
                    String nameToAdd = sc.nextLine();
                    if (set.add(nameToAdd)) {
                        System.out.println(nameToAdd + " added to the set.");
                    } else {
                        System.out.println(nameToAdd + " already exists in the set.");
                    }
                    break;

                case 2:
                    System.out.print("Enter a name to remove: ");
                    String nameToRemove = sc.nextLine();
                    if (set.remove(nameToRemove)) {
                        System.out.println(nameToRemove + " removed from the set.");
                    } else {
                        System.out.println(nameToRemove + " not found in the set.");
                    }
                    break;

                case 3:
                    System.out.print("Enter a name to search: ");
                    String nameToSearch = sc.nextLine();
                    if (set.contains(nameToSearch)) {
                        System.out.println(nameToSearch + " is present in the set.");
                    } else {
                        System.out.println(nameToSearch + " is not found in the set.");
                    }
                    break;

                case 4:
                    System.out.println("Names in forward order:");
                    List<String> list = new ArrayList<>(set);
                    for (String name : list) {
                        System.out.println(name);
                    }

                    System.out.println("\nNames in reverse order:");
                    ListIterator<String> iterator = list.listIterator(list.size());
                    while (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    }
                    break;

                case 5:
                    System.out.println("Number of elements in the set: " + set.size());
                    break;

                case 6:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
