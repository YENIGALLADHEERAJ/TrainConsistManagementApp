import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==========================================\n");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...");

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

        System.out.println("\n==============================================");
        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("==============================================");

        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        System.out.println("\nBefore Sorting:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        System.out.println("\nUC7 sorting completed...");

        System.out.println("\n==============================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("==============================================");

        int threshold = 60;
        System.out.println("Filtering bogies with capacity > " + threshold + "...");

        List<Bogie> highCapacityBogies = bogieList.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        System.out.println("\nHigh-Capacity Bogies Found:");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            highCapacityBogies.forEach(System.out::println);
        }

        System.out.println("\nVerification: Original list size remains: " + bogieList.size());
        System.out.println("UC8 filtering completed...");
    }

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