public class Experiment {
    private Sorter sorter;
    private Searcher searcher;
    public Experiment(){
        this.sorter = new Sorter();
        this.searcher = new Searcher();
    }
    private int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;  //
        }
        return arr;
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
            System.out.println("Error: Unknown sort type. Use 'selection' or 'quick'");
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

        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {
            System.out.println("\n" + "=".repeat(80));
            System.out.println("TESTING WITH ARRAY SIZE: " + size);
            System.out.println("=".repeat(80));

            //RANDOM ARRAYS
            System.out.println("\n--- RANDOM ARRAYS ---");

            int[] randomArray = sorter.generateRandomArray(size);

            System.out.println("Selection Sort:");
            long basicTime = measureSortTime(randomArray, "selection");
            System.out.println("  Time: " + basicTime + " nanoseconds");

            System.out.println("\nQuick Sort:");
            long advancedTime = measureSortTime(randomArray, "quick");
            System.out.println("  Time: " + advancedTime + " nanoseconds");

            if (basicTime > 0 && advancedTime > 0) {
                double ratio = (double) basicTime / advancedTime;
                System.out.println("\nComparison: Quick Sort is " + String.format("%.2f", ratio) + "x faster");
            }

            System.out.println("\nSearching (Linear Search):");
            int target = randomArray[size / 2];
            System.out.println("  Searching for value: " + target);
            long searchTime = measureSearchTime(randomArray, target);
            System.out.println("  Time: " + searchTime + " nanoseconds");

            // SORTED ARRAYS
            System.out.println("\n--- SORTED ARRAYS ---");

            // Create sorted array
            int[] sortedArray = generateSortedArray(size);

            System.out.println("Selection Sort on Sorted Array:");
            long basicSortedTime = measureSortTime(sortedArray, "selection");
            System.out.println("  Time: " + basicSortedTime + " nanoseconds");

            System.out.println("\nQuick Sort on Sorted Array:");
            long advancedSortedTime = measureSortTime(sortedArray, "quick");
            System.out.println("  Time: " + advancedSortedTime + " nanoseconds");

            if (basicSortedTime > 0 && advancedSortedTime > 0) {
                double ratioSorted = (double) basicSortedTime / advancedSortedTime;
                System.out.println("\nComparison: Quick Sort is " + String.format("%.2f", ratioSorted) + "x faster");
            }

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
