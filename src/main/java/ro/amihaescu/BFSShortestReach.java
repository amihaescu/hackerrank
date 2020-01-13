package ro.amihaescu;

import java.util.*;

public class BFSShortestReach {
    private static int mN;
    private static int mM;
    private static Integer mS;

    static int[] bfs(int n, int m, int[][] edges, int s) {
        Map<Integer, Set<Integer>> mNodeToNeigh = new HashMap<>();
        for (int[] edge : edges) {
            int startNode = edge[0];
            int endNode = edge[1];
            Set<Integer> set;
            if (mNodeToNeigh.get(startNode) != null) {
                set = mNodeToNeigh.get(startNode);
            } else {
                set = new HashSet<>();
            }
            set.add(endNode);
            mNodeToNeigh.put(startNode, set);
        }
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> visitedMinDis = new HashMap<>();
        visitedMinDis.put(s, 0);
        queue.add(s);

        while(!queue.isEmpty()) {
            Integer element = queue.remove();
            if (mNodeToNeigh.get(element) != null) {
                for (Integer neigh : mNodeToNeigh.get(element)) {
                    if (!visitedMinDis.containsKey(neigh)) {
                        queue.add(neigh);
                        visitedMinDis.put(neigh, visitedMinDis.get(element) + 1);
                    } else if (visitedMinDis.get(neigh) > visitedMinDis.get(element) + 1) {
                        visitedMinDis.put(neigh, visitedMinDis.get(element) + 1);
                    }
                }
            }
        }
        int[] returnArray = new int[m];
        for (Integer i = 1; i < m; i++) {
            if (!i.equals(s)) {
                Integer dis = visitedMinDis.get(i);
                if (dis == null) {
                    returnArray[i] = -1;
                } else {
                    returnArray[i] = dis * 6;
                }
            }
         }
        return returnArray;
    }
}
