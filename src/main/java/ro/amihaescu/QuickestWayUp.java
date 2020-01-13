package ro.amihaescu;

import java.util.*;

public class QuickestWayUp {

    static int quickestWayUp(int[][] ladders, int[][] snakes) {
        Map<Integer, Integer> mLadders = convert(ladders);
        Map<Integer, Integer> sLadders = convert(snakes);
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        queue.add(1);
        visited.put(1, 0);
        while(!queue.isEmpty()) {
            Integer element = queue.remove();
            for (int i = 1; i <= 6; i++) {
                if (element == 100) {
                    return visited.get(100);
                }
                Integer position = element + i;
                if (mLadders.containsKey(position)) {
                    position = mLadders.get(position);
                } else if (sLadders.containsKey(position)){
                    position = sLadders.get(position);
                }
                if (visited.get(position) == null) {
                    visited.put(position, visited.get(element) + 1);
                    queue.add(position);
                } else if (visited.get(element) + 1 < visited.get(position)) {
                    visited.put(position, visited.get(element + 1));
                }
            }
        }
        return -1;
    }

    private static Map<Integer, Integer> convert(int[][] ladders) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int[] ladder : ladders) {
            map.put(ladder[0], ladder[1]);
        }
        return map;
    }
}
