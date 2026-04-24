//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
                System.out.println("=".repeat(80));
                System.out.println("ALGORITHM PERFORMANCE ANALYSIS SYSTEM");
                System.out.println("=".repeat(80));

                System.out.println("\nSelected Algorithms:");
                System.out.println("  • Basic Sorting:  Selection Sort");
                System.out.println("  • Advanced Sorting: Quick Sort");
                System.out.println("  • Searching:      Linear Search");

                // Instantiate classes
                Sorter sorter = new Sorter();
                Searcher searcher = new Searcher();
                Experiment experiment = new Experiment();

                // Run all experiments
                experiment.runAllExperiments();
                System.out.println("\n" + "=".repeat(80));
                System.out.println("PROGRAM EXECUTION COMPLETED");
                System.out.println("=".repeat(80));
    }
}