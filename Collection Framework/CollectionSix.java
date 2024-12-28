//  3) Create two hash sets {"George", "Jim", "John", "Blake", "Kevin", "Michael"} and {"George", "Katie", 
// "Kevin", "Michelle", "Ryan"}, and find their union, difference, and intersection

import java.util.*;

public class SetOperations {
    public static void main(String[] args) {
        // Create two hash sets with names
        HashSet<String> set1 = new HashSet<>();
        set1.add("George");
        set1.add("Jim");
        set1.add("John");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Michael");

        HashSet<String> set2 = new HashSet<>();
        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michelle");
        set2.add("Ryan");

        // Union: Combine all elements from both sets
        HashSet<String> union = new HashSet<>(set1);  // Create a new set from set1
        union.addAll(set2);  // Add all elements from set2 to the union set
        System.out.println("Union of set1 and set2: " + union);

        // Intersection: Get common elements between both sets
        HashSet<String> intersection = new HashSet<>(set1);  // Create a new set from set1
        intersection.retainAll(set2);  // Retain only common elements
        System.out.println("Intersection of set1 and set2: " + intersection);

        // Difference: Get elements that are in set1 but not in set2
        HashSet<String> difference = new HashSet<>(set1);  // Create a new set from set1
        difference.removeAll(set2);  // Remove all elements in set2 from set1
        System.out.println("Difference of set1 and set2 (set1 - set2): " + difference);
    }
}
