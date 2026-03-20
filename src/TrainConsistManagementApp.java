import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList; // Added for UC4
import java.util.List;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // --- UC1: Initialize Train ---
        System.out.println("==========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==========================================\n");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count : " + trainConsist.size());
        System.out.println("Current Train Consist : " + trainConsist);


        // --- UC2: ArrayList Operations ---
        System.out.println("\n------------------------------------------");
        System.out.println("UC2 - Add Passenger Bogies to Train");
        System.out.println("------------------------------------------");

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        System.out.println("After Adding Bogies: " + trainConsist);

        trainConsist.remove("AC Chair");
        System.out.println("After Removing 'AC Chair': " + trainConsist);
        System.out.println("Contains Sleeper? : " + trainConsist.contains("Sleeper"));


        // --- UC3: HashSet for Uniqueness ---
        System.out.println("\n------------------------------------------");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("------------------------------------------");

        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG104");
        bogieIds.add("BG101"); // Duplicate ignored
        System.out.println("Bogie IDs After Insertion: " + bogieIds);
        System.out.println("Note: Duplicates are automatically ignored by HashSet.");


        // --- UC4: LinkedList for Ordered Consist ---
        System.out.println("\n------------------------------------------");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("------------------------------------------");

        // 1. Initialize LinkedList to model physical chaining
        LinkedList<String> orderedConsist = new LinkedList<>();

        // 2. Add initial bogies
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");

        System.out.println("\nInitial Train Consist:");
        System.out.println(orderedConsist);

        // 3. Insert 'Pantry Car' at position 2 (3rd spot)
        orderedConsist.add(2, "Pantry Car");
        System.out.println("\nAfter Inserting 'Pantry Car' at position 2:");
        System.out.println(orderedConsist);

        // 4. Remove First and Last Bogie
        orderedConsist.removeFirst();
        orderedConsist.removeLast();
        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(orderedConsist);

        System.out.println("\nUC4 ordered consist operations completed...");
    }
}
