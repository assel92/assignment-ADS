import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList;
    private Map<Integer, Vertex> vertexMap;

    public Graph() {
        adjList = new HashMap<>();
        vertexMap = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        int id = v.getId();
        adjList.put(id, new ArrayList<>());
        vertexMap.put(id, v);
    }

    public void addEdge(int from, int to) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
    }

    public void printGraph() {
        for (int vertex : adjList.keySet()) {
            System.out.print(vertexMap.get(vertex) + " -> ");
            for (int neighbor : adjList.get(vertex)) {
                System.out.print(vertexMap.get(neighbor) + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        if (!adjList.containsKey(start)) {
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(vertexMap.get(current) + " ");

            for (int neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        if (!adjList.containsKey(start)) {
            return;
        }

        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertexMap.get(vertex) + " ");

        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}