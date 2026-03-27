import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==========================================\n");

        // Previous Use Cases (UC1 - UC10) logic summarized for brevity
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        System.out.println("UC10 - Total Seating Capacity: " +
                bogieList.stream().map(b -> b.capacity).reduce(0, Integer::sum));

        System.out.println("\n==============================================");
        System.out.println("UC11 - Validate Train ID & Cargo Codes (Regex)");
        System.out.println("==============================================");
        validateInput("Train ID", "TRN-1234", "TRN-\\d{4}");
        validateInput("Cargo Code", "PET-AB", "PET-[A-Z]{2}");

        System.out.println("\n==============================================");
        System.out.println("UC12 - Safety Compliance Check (allMatch)");
        System.out.println("==============================================");

        // 1. Create a list of Goods Bogies with types and cargo
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // 2. Use allMatch() to verify safety rules
        // Rule: If type is Cylindrical, cargo must be Petroleum
        boolean isSafe = goodsBogies.stream().allMatch(b ->
                !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum")
        );

        System.out.println("Goods Bogie Formation: ");
        goodsBogies.forEach(System.out::println);

        System.out.println("\nSafety Compliance Result: " + (isSafe ? "SAFE" : "UNSAFE"));
        System.out.println("UC12 safety check completed...");
    }

    private static void validateInput(String label, String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        System.out.println(label + " [" + input + "] -> " + (matcher.matches() ? "VALID" : "INVALID"));
    }

    static class Bogie {
        String type;
        int capacity;
        Bogie(String type, int capacity) { this.type = type; this.capacity = capacity; }
        @Override public String toString() { return type + " -> " + capacity; }
    }

    // New class for UC12
    static class GoodsBogie {
        String type;
        String cargo;
        GoodsBogie(String type, String cargo) { this.type = type; this.cargo = cargo; }
        @Override public String toString() { return "[" + type + " | Cargo: " + cargo + "]"; }
    }
}