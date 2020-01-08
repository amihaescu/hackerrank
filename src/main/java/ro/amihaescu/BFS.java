package ro.amihaescu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BFS {

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> distances = new HashMap<>();
        recurseThroughChildren(edges, s, visited, distances);
        int[] distanceArray = new int[n -1];
        for (int i = 1; i < n ; i++) {
            distanceArray[i - 1] = distances.getOrDefault(i + 1, -1);
        }
        return distanceArray;
    }

    private static void recurseThroughChildren(int[][] edges, int s, Set<Integer> visited, Map<Integer, Integer> distances) {
        Set<Integer> children = new HashSet<>();
        for (int[] edge : edges) {
            if (edge[0] == s ) {
                visited.add(s);
                children.add(edge[1]);
                distances.put(edge[1], distances.getOrDefault(edge[0], 0) + 6);
            }
        }
        for (Integer child : children) {
            recurseThroughChildren(edges, child, visited, distances);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = Integer.parseInt(scanner.nextLine());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine();
            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                System.out.printf("%s " ,String.valueOf(result[i]));

                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        scanner.close();
    }

}
