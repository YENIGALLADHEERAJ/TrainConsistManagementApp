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

    public boolean binarySearch(String[] bogieIds, String searchKey) {
        Arrays.sort(bogieIds);
        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = searchKey.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true;
            } else if (comparison > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

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
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("==========================================\n");

        String[] bogieIds = {"BG6412", "BG205", "BG101", "BG550", "BG309"};
        String searchKey = "BG309";

        Arrays.sort(bogieIds);
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        System.out.println("\nSearching for Bogie ID: " + searchKey);

        if (app.binarySearch(bogieIds, searchKey)) {
            System.out.println("Bogie " + searchKey + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + searchKey + " not found.");
        }

        System.out.println("\nUC19 search completed...");
    }
}
