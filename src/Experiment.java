import java.util.Arrays;
public class Experiment {
    private Sorter sorter;
    private Searcher searcher;
    public Experiment(){
        this.sorter = new Sorter();
        this.searcher = new Searcher();
    }
    public long measureSortTime(int[] arr, String type){
        // Start timing
        long startTime = System.nanoTime();

        // Execute the appropriate sorting algorithm
        if (type.equalsIgnoreCase("selection")) {
            sorter.SelectionSort(arr);  // Basic sorting algorithm
        } else if (type.equalsIgnoreCase("quick")) {
            sorter.QuickSort(arr);      // Advanced sorting algorithm
        } else {
            System.out.println("Error: Unknown sort type. Use 'basic' or 'advanced'");
            return -1;
        }

        // End timing
        long endTime = System.nanoTime();

        // Return execution time in nanoseconds
        return endTime - startTime;
    }
    public long measureSearchTime(int[] arr, int target){
        // Start timing
        long startTime = System.nanoTime();

        // Execute linear search
        searcher.LinearSearch(arr, target);

        // End timing
        long endTime = System.nanoTime();

        // Return execution time in nanoseconds
        return endTime - startTime;
    }
public void runAllExperiments(){
        System.out.println("=".repeat(80));
        System.out.println("ALGORITHM PERFORMANCE EXPERIMENT");
        System.out.println("=".repeat(80));

        // Test different array sizes: Small (10), Medium (100), Large (1000)
        int[] sizes = {10, 100, 1000};
        for (int size : sizes) {
            System.out.println("\n" + "=".repeat(80));
            System.out.println("TESTING WITH ARRAY SIZE: " + size);
            System.out.println("=".repeat(80));
            System.out.println("\n--- RANDOM ARRAYS ---");

            // Generate random array using Sorter's generateRandomArray method
            int[] randomArray =sorter.generateRandomArray(size);

            // Measure Basic Sort time
            System.out.println("Basic Sorting (Selection Sort):");
            long basicTime = measureSortTime(randomArray, "selection");
            System.out.println("  Time: " + basicTime + " nanoseconds");

            // Measure Advanced Sort time
            System.out.println("\nAdvanced Sorting (Quick Sort):");
            long advancedTime = measureSortTime(randomArray, "quick");
            System.out.println("  Time: " + advancedTime + " nanoseconds");

            // Compare sorting algorithms
            if (basicTime > 0 && advancedTime > 0) {
                double ratio = (double) basicTime / advancedTime;
                System.out.println("\nComparison: Quick Sort is " + String.format("%.2f", ratio) + "x faster than Selection Sort");
            }
            // Measure Search time (Linear Search)
            System.out.println("\nSearching (Linear Search):");
            int target = randomArray[size / 2];
            System.out.println("  Searching for value: " + target);
            long searchTime = measureSearchTime(randomArray, target);
            System.out.println("  Time: " + searchTime + " nanoseconds");

            System.out.println("\n--- SORTED ARRAYS ---");

            // Generate sorted array manually
            int[] sortedArray = new int[size];
            for (int i = 0; i < size; i++) {
                sortedArray[i] = i;
            }

            // Measure Basic Sort on sorted array
            System.out.println("Basic Sorting (Selection Sort) on Sorted Array:");
            long basicSortedTime = measureSortTime(sortedArray, "selection");
            System.out.println("  Time: " + basicSortedTime + " nanoseconds");

            // Measure Advanced Sort on sorted array
            System.out.println("\nAdvanced Sorting (Quick Sort) on Sorted Array:");
            long advancedSortedTime = measureSortTime(sortedArray, "quick");
            System.out.println("  Time: " + advancedSortedTime + " nanoseconds");

            // Compare on sorted arrays
            if (basicSortedTime > 0 && advancedSortedTime > 0) {
                double ratioSorted = (double) basicSortedTime / advancedSortedTime;
                System.out.println("\nComparison: Quick Sort is " + String.format("%.2f", ratioSorted) + "x faster than Selection Sort");
            }
            // Measure Search on sorted array
            System.out.println("\nSearching (Linear Search) on Sorted Array:");
            long searchSortedTime = measureSearchTime(sortedArray, sortedArray[size / 2]);
            System.out.println("  Time: " + searchSortedTime + " nanoseconds");
        }

        // Print final summary
        System.out.println("\n" + "=".repeat(80));
        System.out.println("EXPERIMENT SUMMARY");
        System.out.println("=".repeat(80));
        System.out.println("Algorithms Tested:");
        System.out.println("  • Basic Sorting: Selection Sort");
        System.out.println("  • Advanced Sorting: Quick Sort");
        System.out.println("  • Searching: Linear Search");
        System.out.println("\nArray Sizes Tested:");
        System.out.println("  • Small: 10 elements");
        System.out.println("  • Medium: 100 elements");
        System.out.println("  • Large: 1000 elements");
        System.out.println("\nArray Types Tested:");
        System.out.println("  • Random Arrays");
        System.out.println("  • Sorted Arrays");
        System.out.println("\n" + "=".repeat(80));
        System.out.println("EXPERIMENT COMPLETED");
        System.out.println("=".repeat(80));
    }
}
