import java.util.*;

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

public class TrainConsistManagementApp {

    public String assignCargo(String bogieShape, String cargoType) {
        try {
            if (cargoType.equalsIgnoreCase("Petroleum") && bogieShape.equalsIgnoreCase("Rectangular")) {
                throw new CargoSafetyException("Unsafe Assignment");
            }
            return "SUCCESS";
        } catch (CargoSafetyException e) {
            return "FAILED: " + e.getMessage();
        } finally {
            System.out.println("Validation completed for " + bogieShape);
        }
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();
        System.out.println(app.assignCargo("Cylindrical", "Petroleum"));
        System.out.println("UC15 exception handling completed...");
    }

    static class Bogie {
        String type;
        int capacity;

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
