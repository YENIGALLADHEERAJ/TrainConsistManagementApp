import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project: Train Consist Management App
 * Focus: Core Java & Data Structures (ArrayList & HashSet)
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // ==========================================
        // UC1: Initialize Train and Display Consist Summary
        // ==========================================
        System.out.println("==========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==========================================\n");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count : " + trainConsist.size());
        System.out.println("Current Train Consist : " + trainConsist);
        System.out.println("\nSystem ready for operations...");


        // ==========================================
        // UC2: Add Passenger Bogies to Train
        // ==========================================
        System.out.println("\n==========================================");
        System.out.println("UC2 - Add Passenger Bogies to Train");
        System.out.println("==========================================");

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("\nAfter Adding Bogies:");
        System.out.println("Passenger Bogies : " + trainConsist);

        trainConsist.remove("AC Chair");

        System.out.println("\nAfter Removing 'AC Chair':");
        System.out.println("Passenger Bogies : " + trainConsist);

        System.out.println("\nChecking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + trainConsist.contains("Sleeper"));

        System.out.println("\nFinal Train Passenger Consist:");
        System.out.println(trainConsist);
        System.out.println("\nUC2 operations completed successfully...");


        // ==========================================
        // UC3: Track Unique Bogie IDs (HashSet)
        // ==========================================
        System.out.println("\n==========================================");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("==========================================");

        // 1. Initialize HashSet to store unique Bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // 2. Adding IDs including a duplicate "BG101"
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG104");
        bogieIds.add("BG101"); // This is a duplicate and will be ignored

        // 3. Display the set (Note: HashSet does not maintain insertion order)
        System.out.println("\nBogie IDs After Insertion:");
        System.out.println(bogieIds);

        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");

        System.out.println("\nUC3 uniqueness validation completed...");
    }
}
