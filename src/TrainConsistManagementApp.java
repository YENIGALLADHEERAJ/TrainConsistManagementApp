import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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

        // ... UC6 to UC10 Logic remains as previously implemented ...

        System.out.println("\n==============================================");
        System.out.println("UC10 - Count Total Seats in Train (reduce)");
        System.out.println("==============================================");
        int totalSeats = bogieList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        System.out.println("Total Seating Capacity: " + totalSeats);

        System.out.println("\n==============================================");
        System.out.println("UC11 - Validate Train ID & Cargo Codes (Regex)");
        System.out.println("==============================================");

        // 1. Define Regex Patterns
        String trainIDPattern = "TRN-\\d{4}";
        String cargoCodePattern = "PET-[A-Z]{2}";

        // 2. Sample Inputs for Validation
        String inputTrainID = "TRN-1234";
        String inputCargoCode = "PET-AB";
        String invalidTrainID = "TRAIN12";

        // 3. Perform Validation using Pattern and Matcher
        validateInput("Train ID", inputTrainID, trainIDPattern);
        validateInput("Train ID (Invalid Test)", invalidTrainID, trainIDPattern);
        validateInput("Cargo Code", inputCargoCode, cargoCodePattern);

        System.out.println("\nUC11 regex validation completed...");
    }

    private static void validateInput(String label, String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("✔ " + label + " [" + input + "] is VALID.");
        } else {
            System.out.println("❌ " + label + " [" + input + "] is INVALID.");
        }
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