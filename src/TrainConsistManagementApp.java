import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==========================================\n");

        // --- UC1 to UC10 Summarized ---
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        // --- UC11: Regex Validation ---
        System.out.println("\nUC11 - Regex Validation:");
        validateInput("Train ID", "TRN-1234", "TRN-\\d{4}");

        // --- UC12: Safety Compliance ---
        System.out.println("\nUC12 - Safety Check:");
        List<GoodsBogie> goodsBogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );
        boolean isSafe = goodsBogies.stream().allMatch(b ->
                !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum"));
        System.out.println("Safety Compliance: " + (isSafe ? "SAFE" : "UNSAFE"));

        // --- UC13: Performance Comparison (Loops vs Streams) ---
        System.out.println("\n==============================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("==============================================");

        // 1. Prepare a larger dataset for meaningful measurement
        List<Bogie> largeBogieList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            largeBogieList.add(new Bogie("Bogie-" + i, (int) (Math.random() * 100)));
        }

        // 2. Loop-Based Filtering Performance
        long startTimeLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : largeBogieList) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        // 3. Stream-Based Filtering Performance
        long startTimeStream = System.nanoTime();
        List<Bogie> streamFiltered = largeBogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        // 4. Display Results
        System.out.println("Loop-Based Time   : " + durationLoop + " ns");
        System.out.println("Stream-Based Time : " + durationStream + " ns");
        System.out.println("Result Match      : " + (loopFiltered.size() == streamFiltered.size()));
        System.out.println("UC13 performance comparison completed...");
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

    static class GoodsBogie {
        String type;
        String cargo;
        GoodsBogie(String type, String cargo) { this.type = type; this.cargo = cargo; }
        @Override public String toString() { return "[" + type + " | " + cargo + "]"; }
    }
}