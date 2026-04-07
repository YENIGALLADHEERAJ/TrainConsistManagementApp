import java.util.*;

public class TrainConsistManagementApp {

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
        System.out.println("UC16 - Manual Sorting using Bubble Sort");
        System.out.println("==========================================\n");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities:");
        for (int val : capacities) System.out.print(val + " ");

        app.bubbleSort(capacities);

        System.out.println("\n\nSorted Capacities (Ascending):");
        for (int val : capacities) System.out.print(val + " ");

        System.out.println("\n\nUC16 sorting completed...");
    }
}
