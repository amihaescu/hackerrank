package ro.amihaescu;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.binarySearch;
import static java.util.stream.IntStream.range;

public class Solution {

    String condenseArray(int[] array) {
        boolean isSequence = false;
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < array.length; index++) {
            int diff = diff(array, index);
            if (diff != 1 && !isSequence) {
                sb.append(array[index]);
                if (index != array.length - 1) sb.append(",");
            } else if (diff == 1 && !isSequence) {
                isSequence = true;
                sb.append(array[index]).append("-");
            } else if (diff != 1) {
                sb.append(array[index]);
                if (index != array.length - 1) sb.append(",");
                isSequence = false;
            }
        }
        return sb.toString();
    }

    private static int diff(int[] array, int position) {
        if (position == array.length - 1)
            return -1;
        return array[position + 1] - array[position];
    }

    int pickingNumbers(List<Integer> list) {
        return list.stream()
                .mapToInt(integer -> Collections.frequency(list, integer) + Collections.frequency(list, integer + 1))
                .max().orElse(0);
    }

    int[] climbingLeaderBoard(int[] scores, int[] alice) {
        int[] positions = new int[alice.length];
        int[] array = range(0, scores.length).map(i -> scores[scores.length - i - 1]).distinct().toArray();
        int index = 0;
        for (int scoreIndex = 0; scoreIndex < alice.length;  scoreIndex++) {
            index = binarySearch(array, Math.max(index, 0), array.length, alice[scoreIndex]);
            if (index < 0) index = -index - 2;
            positions[scoreIndex] = array.length - index;
        }
        return positions;
    }
}
