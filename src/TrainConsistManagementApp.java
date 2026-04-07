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

    public boolean linearSearch(String[] bogieIds, String searchKey) {
        for (String id : bogieIds) {
            if (id.equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

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
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("==========================================\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        System.out.println("\nSearching for Bogie ID: " + searchKey);

        if (app.linearSearch(bogieIds, searchKey)) {
            System.out.println("Bogie " + searchKey + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchKey + " not found.");
        }

        System.out.println("\nUC18 search completed...");
    }
}
