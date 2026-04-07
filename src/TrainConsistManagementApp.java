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

    public boolean searchWithValidation(String[] bogieIds, String searchKey) {
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        for (String id : bogieIds) {
            if (id.equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(String[] bogieIds, String searchKey) {
        if (bogieIds == null || bogieIds.length == 0) return false;
        Arrays.sort(bogieIds);
        int low = 0;
        int high = bogieIds.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = searchKey.compareTo(bogieIds[mid]);
            if (comparison == 0) return true;
            else if (comparison > 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public boolean linearSearch(String[] bogieIds, String searchKey) {
        for (String id : bogieIds) {
            if (id.equals(searchKey)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("==========================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("==========================================\n");

        String[] emptyBogieIds = {};
        String searchKey = "BG101";

        // This will trigger the exception as per the requirement image
        app.searchWithValidation(emptyBogieIds, searchKey);
    }
}
