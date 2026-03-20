import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // --- UC1: Initialize Train ---
        System.out.println("==========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==========================================\n");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...");


        // --- UC2 to UC5 (Summarized for space) ---
        // [Logic for ArrayList, HashSet, LinkedList, and LinkedHashSet remains above]

        // --- UC6: Map Bogie to Capacity (HashMap) ---
        System.out.println("\n==========================================");
        System.out.println("UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("==========================================");

        // 1. Initialize HashMap: Key (String - Bogie Name) -> Value (Integer - Capacity)
        Map<String, Integer> bogieCapacities = new HashMap<>();

        // 2. Map bogies to their respective capacities using put()
        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("Cargo", 120);
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 56);

        // 3. Display the mapping
        System.out.println("\nBogie Capacity Details:");

        // Iterating using entrySet() to see both Key and Value
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}
