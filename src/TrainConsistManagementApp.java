import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==========================================\n");

        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));

        System.out.println("\n==========================================");
        System.out.println("UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("==========================================");
        Map<String, Integer> bogieCapacities = new HashMap<>();
        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("Cargo", 120);
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 56);
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\n==============================================");
        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("==============================================");
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));
        bogieList.forEach(System.out::println);

        System.out.println("\n==============================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("==============================================");
        List<Bogie> highCapacityBogies = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        highCapacityBogies.forEach(System.out::println);

        System.out.println("\n==============================================");
        System.out.println("UC9 - Group Bogies by Type (groupingBy)");
        System.out.println("==============================================");

        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(b -> b.type));

        groupedBogies.forEach((type, list) -> {
            System.out.println("\nType: " + type);
            list.forEach(b -> System.out.println("  - " + b));
        });

        System.out.println("\nVerification: Total groups formed: " + groupedBogies.size());
        System.out.println("UC9 grouping completed...");
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
            return type + " (Cap: " + capacity + ")";
        }
    }
}