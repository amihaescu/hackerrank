package ro.amihaescu;

import java.io.IOException;
import java.util.*;

public class BFS {

    static class Node {
        int data;
        List<Node> childern = new ArrayList<>();

        public Node(int data) {
            this.data = data;
        }

        public void add(int value) {
            childern.add(new Node(value));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data == node.data;
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }

    // Complete the bfs function below.
    static int[] bfs(int nodes, int edgesNumber, int[][] edges, int s) {
        Node root = new Node(s);
        Set<Integer> visited = new HashSet<>();
        addChildren(root, edges, visited);
        Map<Node, Integer> distances = new HashMap<>();
        computeDistances(distances, root, 0);
        int[] distanceArray = new int[nodes - 1];
        int index = 0;
        for (int i = 1; i < nodes + 1; i++) {
            if (i != s) {
                distanceArray[index++] = distances.getOrDefault(new Node(i), -1);
            }

        }
        for (Map.Entry<Node, Integer> entry : distances.entrySet()) {
            System.out.println(entry.getKey().data + " - " + entry.getValue());
        }
        return distanceArray;
    }

    private static void computeDistances(Map<Node, Integer> distances, Node node, int distance) {
        distance += 6;
        for (Node child : node.childern) {
            distances.put(child, distance);
            computeDistances(distances, child, distance);
        }
    }

    private static void addChildren(Node node, int[][] edges, Set<Integer> visited) {
        for (int[] edge : edges) {
            if (edge[0] == node.data) {
                if (!visited.contains(edge[1])) {
                    node.add(edge[1]);
                    visited.add(edge[1]);
                }
            }
        }
        for (Node child : node.childern) {
            addChildren(child, edges, visited);
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
                System.out.printf("%s ", String.valueOf(result[i]));

                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        scanner.close();
    }

}
