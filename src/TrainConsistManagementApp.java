import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // UC1: Initialize Train and Display Consist Summary

        // 1. Print a welcome message
        System.out.println("==========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==========================================\n");

        // 2. Initialize an empty List using ArrayList to store bogies
        // Using List interface for flexibility (abstraction)
        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully...");

        // 3. Display the initial bogie count using size()
        System.out.println("Initial Bogie Count : " + trainConsist.size());

        // 4. Display the current train consist (should be empty [])
        System.out.println("Current Train Consist : " + trainConsist);

        System.out.println("\nSystem ready for operations...");
    }
}
