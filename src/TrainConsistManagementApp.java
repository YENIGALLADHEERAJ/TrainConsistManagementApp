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

    public String[] sortBogieNames(String[] names) {
        Arrays.sort(names);
        return names;
    }

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

    public int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("==========================================");
        System.out.println("UC17 - Sorted Bogie Names using Arrays.sort()");
        System.out.println("==========================================\n");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names: " + Arrays.toString(bogieNames));

        app.sortBogieNames(bogieNames);

        System.out.println("Sorted Bogie Names (Alphabetical): " + Arrays.toString(bogieNames));

        System.out.println("\nUC17 library-based sorting completed...");
    }
}
