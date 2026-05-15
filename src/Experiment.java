import java.util.*;

public class Experiment {

    public void runTraversals(Graph g) {
        System.out.println("Running traversals:");
        g.printGraph();

        System.out.print("BFS: ");
        g.bfs(0);

        System.out.print("DFS: ");
        g.dfs(0);
    }

    public void runMultipleTests() {
        System.out.println("Running multiple tests...\n");
        Random rand = new Random(42); // Fixed seed for reproducible results

        // Store results for table
        long bfsTime10 = 0, dfsTime10 = 0;
        long bfsTime30 = 0, dfsTime30 = 0;
        long bfsTime100 = 0, dfsTime100 = 0;

        // === SMALL GRAPH (10 vertices) - Random Branching Graph ===
        System.out.println("=== SMALL GRAPH (10 vertices - Random Branching Structure) ===");
        Graph smallGraph = new Graph();
        for (int i = 0; i < 10; i++) {
            smallGraph.addVertex(new Vertex(i));
        }
        // Add random edges with 30% density for good branching
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i != j && rand.nextDouble() < 0.3) {
                    smallGraph.addEdge(i, j);
                }
            }
        }

        // Measure BFS separately
        long start = System.nanoTime();
        System.out.print("BFS: ");
        smallGraph.bfs(0);
        long end = System.nanoTime();
        bfsTime10 = end - start;

        // Measure DFS separately
        start = System.nanoTime();
        System.out.print("DFS: ");
        smallGraph.dfs(0);
        end = System.nanoTime();
        dfsTime10 = end - start;
        System.out.println();

        // === MEDIUM GRAPH (30 vertices) - Random Branching Graph ===
        System.out.println("\n=== MEDIUM GRAPH (30 vertices - Random Branching Structure) ===");
        Graph mediumGraph = new Graph();
        for (int i = 0; i < 30; i++) {
            mediumGraph.addVertex(new Vertex(i));
        }
        // Add random edges with 20% density for good branching
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (i != j && rand.nextDouble() < 0.2) {
                    mediumGraph.addEdge(i, j);
                }
            }
        }

        // Measure BFS separately
        start = System.nanoTime();
        System.out.print("BFS: ");
        mediumGraph.bfs(0);
        end = System.nanoTime();
        bfsTime30 = end - start;

        // Measure DFS separately
        start = System.nanoTime();
        System.out.print("DFS: ");
        mediumGraph.dfs(0);
        end = System.nanoTime();
        dfsTime30 = end - start;
        System.out.println();

        // === LARGE GRAPH (100 vertices) - Random Branching Graph ===
        System.out.println("\n=== LARGE GRAPH (100 vertices - Random Branching Structure) ===");
        Graph largeGraph = new Graph();
        for (int i = 0; i < 100; i++) {
            largeGraph.addVertex(new Vertex(i));
        }
        // Add random edges with 10% density for good branching
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i != j && rand.nextDouble() < 0.1) {
                    largeGraph.addEdge(i, j);
                }
            }
        }

        // Measure BFS separately
        start = System.nanoTime();
        System.out.print("BFS: ");
        largeGraph.bfs(0);
        end = System.nanoTime();
        bfsTime100 = end - start;

        // Measure DFS separately
        start = System.nanoTime();
        System.out.print("DFS: ");
        largeGraph.dfs(0);
        end = System.nanoTime();
        dfsTime100 = end - start;
        System.out.println();

        // Store results for printResults
        results.put("small_bfs", bfsTime10);
        results.put("small_dfs", dfsTime10);
        results.put("medium_bfs", bfsTime30);
        results.put("medium_dfs", dfsTime30);
        results.put("large_bfs", bfsTime100);
        results.put("large_dfs", dfsTime100);
    }

    // Store results
    private Map<String, Long> results = new HashMap<>();

    public void printResults() {
        System.out.println("\n\n");
        System.out.println("============================================================");
        System.out.println("                    EXPERIMENT RESULTS                       ");
        System.out.println("============================================================");
        System.out.printf("%-15s %-20s %-20s %-20s\n", "Graph Size", "BFS Time (ns)", "DFS Time (ns)", "Difference");
        System.out.println("------------------------------------------------------------");

        long smallBfs = results.getOrDefault("small_bfs", 0L);
        long smallDfs = results.getOrDefault("small_dfs", 0L);
        long mediumBfs = results.getOrDefault("medium_bfs", 0L);
        long mediumDfs = results.getOrDefault("medium_dfs", 0L);
        long largeBfs = results.getOrDefault("large_bfs", 0L);
        long largeDfs = results.getOrDefault("large_dfs", 0L);

        System.out.printf("%-15s %-20d %-20d %-20d\n", "10 vertices", smallBfs, smallDfs, Math.abs(smallBfs - smallDfs));
        System.out.printf("%-15s %-20d %-20d %-20d\n", "30 vertices", mediumBfs, mediumDfs, Math.abs(mediumBfs - mediumDfs));
        System.out.printf("%-15s %-20d %-20d %-20d\n", "100 vertices", largeBfs, largeDfs, Math.abs(largeBfs - largeDfs));

        System.out.println("============================================================");

        // Analysis
        System.out.println("\n=== ANALYSIS ===");
        if (smallBfs < smallDfs) {
            System.out.println("Small graph: BFS was faster than DFS by " + (smallDfs - smallBfs) + " ns");
        } else if (smallDfs < smallBfs) {
            System.out.println("Small graph: DFS was faster than BFS by " + (smallBfs - smallDfs) + " ns");
        } else {
            System.out.println("Small graph: BFS and DFS had equal performance");
        }

        if (mediumBfs < mediumDfs) {
            System.out.println("Medium graph: BFS was faster than DFS by " + (mediumDfs - mediumBfs) + " ns");
        } else if (mediumDfs < mediumBfs) {
            System.out.println("Medium graph: DFS was faster than BFS by " + (mediumBfs - mediumDfs) + " ns");
        } else {
            System.out.println("Medium graph: BFS and DFS had equal performance");
        }

        if (largeBfs < largeDfs) {
            System.out.println("Large graph: BFS was faster than DFS by " + (largeDfs - largeBfs) + " ns");
        } else if (largeDfs < largeBfs) {
            System.out.println("Large graph: DFS was faster than BFS by " + (largeBfs - largeDfs) + " ns");
        } else {
            System.out.println("Large graph: BFS and DFS had equal performance");
        }
    }
}