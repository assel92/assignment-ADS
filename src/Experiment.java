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
        System.out.println("=== SMALL GRAPH (10 vertices) ===");
        Graph smallGraph = new Graph();
        for (int i = 0; i < 10; i++) {
            smallGraph.addVertex(new Vertex(i));
        }
        for (int i = 0; i < 9; i++) {
            smallGraph.addEdge(i, i + 1);
        }

        long start = System.nanoTime();
        runTraversals(smallGraph);
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) + " ns\n");
        System.out.println("=== MEDIUM GRAPH (30 vertices) ===");
        Graph mediumGraph = new Graph();
        for (int i = 0; i < 30; i++) {
            mediumGraph.addVertex(new Vertex(i));
        }
        for (int i = 0; i < 29; i++) {
            mediumGraph.addEdge(i, i + 1);
        }

        start = System.nanoTime();
        mediumGraph.printGraph();
        System.out.print("BFS: ");
        mediumGraph.bfs(0);
        System.out.print("DFS: ");
        mediumGraph.dfs(0);
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) + " ns\n");

        System.out.println("=== LARGE GRAPH (100 vertices) ===");
        Graph largeGraph = new Graph();
        for (int i = 0; i < 100; i++) {
            largeGraph.addVertex(new Vertex(i));
        }
        for (int i = 0; i < 99; i++) {
            largeGraph.addEdge(i, i + 1);
        }

        start = System.nanoTime();
        System.out.print("BFS: ");
        largeGraph.bfs(0);
        System.out.print("DFS: ");
        largeGraph.dfs(0);
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) + " ns\n");
    }

    public void printResults() {
        System.out.println("========================================");
        System.out.println("EXPERIMENT RESULTS");
        System.out.println("========================================");
        System.out.println("Graph Size | Traversal Type | Time (ns)");
        System.out.println("----------------------------------------");
        System.out.println("10         | BFS/DFS        | Measured above");
        System.out.println("30         | BFS/DFS        | Measured above");
        System.out.println("100        | BFS/DFS        | Measured above");
        System.out.println("========================================");
    }
}
