import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // --- UC1: Initialize Train ---
        System.out.println("==========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==========================================\n");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count : " + trainConsist.size());


        // --- UC2: ArrayList Operations ---
        System.out.println("\n------------------------------------------");
        System.out.println("UC2 - Add Passenger Bogies to Train");
        System.out.println("------------------------------------------");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        trainConsist.remove("AC Chair");
        System.out.println("Final Train Passenger Consist: " + trainConsist);


        // --- UC3: HashSet for Uniqueness ---
        System.out.println("\n------------------------------------------");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("------------------------------------------");
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG101"); // Duplicate
        System.out.println("Bogie IDs (Unique): " + bogieIds);


        // --- UC4: LinkedList for Ordered Consist ---
        System.out.println("\n------------------------------------------");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("------------------------------------------");
        LinkedList<String> orderedConsist = new LinkedList<>();
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");
        orderedConsist.add(2, "Pantry Car");
        orderedConsist.removeFirst();
        orderedConsist.removeLast();
        System.out.println("Ordered Consist: " + orderedConsist);


        // --- UC5: Preserve Insertion Order of Bogies (LinkedHashSet) ---
        System.out.println("\n==========================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("==========================================");

        // 1. Initialize LinkedHashSet to maintain order AND uniqueness
        Set<String> trainFormation = new LinkedHashSet<>();

        // 2. Attach bogies in a specific sequence
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // 3. Attempt to add a duplicate bogie ("Sleeper")
        // LinkedHashSet will see it already exists and ignore it.
        trainFormation.add("Sleeper");

        // 4. Display the results
        System.out.println("\nFinal Train Formation:");
        System.out.println(trainFormation);

        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("\nUC5 formation setup completed...");
    }
}
