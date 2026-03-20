import java.util.ArrayList;
import java.util.List;

/**
 * Project: Train Consist Management App
 * Focus: Core Java & Data Structures (ArrayList Operations)
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // ==========================================
        // UC1: Initialize Train and Display Consist Summary
        // ==========================================
        System.out.println("==========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==========================================\n");

        // Initializing the consist using List interface and ArrayList implementation
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

        // 1. Adding bogies (Create)
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("\nAfter Adding Bogies:");
        System.out.println("Passenger Bogies : " + trainConsist);

        // 2. Removing a bogie (Delete)
        trainConsist.remove("AC Chair");

        System.out.println("\nAfter Removing 'AC Chair':");
        System.out.println("Passenger Bogies : " + trainConsist);

        // 3. Checking existence (Read/Search)
        System.out.println("\nChecking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + trainConsist.contains("Sleeper"));

        // 4. Final state for UC2
        System.out.println("\nFinal Train Passenger Consist:");
        System.out.println(trainConsist);

        System.out.println("\nUC2 operations completed successfully...");
    }
}
