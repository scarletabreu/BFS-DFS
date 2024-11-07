import Classes.Graph;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matriz = {
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {0, 1, 1, 0}
        };

        Graph graph = new Graph(matriz);
        System.out.println("Matriz de adyacencia:" + Arrays.deepToString(matriz));
        System.out.println("Recorrido utilizando BFS: " + graph.BFS(0));
        System.out.println("Recorrido utilizando DFS" + graph.DFS(0));
    }
}