package Classes;

import java.util.*;

public class Graph {
    private final Map<Integer, List<Integer>> adjacencyList;

    // Constructor que convierte la matriz de adyacencia en una lista de adyacencia
    public Graph(int[][] adjacencyMatrix) {
        adjacencyList = new HashMap<>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            adjacencyList.put(i, new ArrayList<>());
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    adjacencyList.get(i).add(j);
                }
            }
        }
    }

    // Método BFS
    public List<Integer> BFS(int start) {
        boolean[] visited = new boolean[adjacencyList.size()];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> route = new ArrayList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            route.add(current);
            System.out.println(current);
            for (int neighbor : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return route;
    }

    // Método DFS
    public List<Integer> DFS(int start) {
        List<Integer> route = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                route.add(current);
                for (int neighbor : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                    stack.push(neighbor);
                }
            }
        }

        return route;
    }
}
