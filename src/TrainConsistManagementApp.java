import java.util.*;

// Define the custom exception for UC14
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==========================================\n");

        List<Bogie> bogieList = new ArrayList<>();

        System.out.println("UC14 - Handle Invalid Bogie Capacity (Custom Exception)");
        System.out.println("==============================================");

        try {
            // Test Case 1: Valid Capacity
            System.out.println("Attempting to create valid bogie (Sleeper, 72)...");
            bogieList.add(new Bogie("Sleeper", 72));
            System.out.println("✔ Successfully added Sleeper bogie.");

            // Test Case 2: Zero Capacity (Should fail)
            System.out.println("\nAttempting to create invalid bogie (General, 0)...");
            bogieList.add(new Bogie("General", 0));

        } catch (InvalidCapacityException e) {
            System.out.println("❌ Validation Failed: " + e.getMessage());
        }

        try {
            // Test Case 3: Negative Capacity (Should fail)
            System.out.println("\nAttempting to create invalid bogie (AC Chair, -10)...");
            bogieList.add(new Bogie("AC Chair", -10));

        } catch (InvalidCapacityException e) {
            System.out.println("❌ Validation Failed: " + e.getMessage());
        }

        System.out.println("\nFinal Bogie Count in Train: " + bogieList.size());
        System.out.println("UC14 custom exception handling completed...");
    }

    static class Bogie {
        String type;
        int capacity;

        // Constructor updated with UC14 validation logic
        Bogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }
}