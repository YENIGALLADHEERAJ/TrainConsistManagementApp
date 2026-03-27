import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // --- UC1 to UC5 (Existing logic remains here) ---
        System.out.println("==========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==========================================\n");

        // --- UC6: Map Bogie to Capacity (HashMap) ---
        System.out.println("\n==========================================");
        System.out.println("UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("==========================================");

        Map<String, Integer> bogieCapacities = new HashMap<>();
        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("Cargo", 120);
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 56);

        System.out.println("\nBogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("\nUC6 bogie-capacity mapping completed...");

        // --- UC7: Sort Bogies by Capacity (Comparator) ---
        System.out.println("\n==============================================");
        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("==============================================");

        // 1. Initialize List with Bogie objects
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        // 2. Display Before Sorting
        System.out.println("\nBefore Sorting:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        // 3. Apply Comparator to sort by capacity (Ascending)
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        // 4. Display After Sorting
        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        System.out.println("\nUC7 sorting completed...");
    }

    // Static inner class to keep everything in one file
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }
}