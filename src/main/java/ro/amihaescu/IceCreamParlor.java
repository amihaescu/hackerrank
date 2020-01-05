package ro.amihaescu;

import java.util.HashMap;
import java.util.Map;

public class IceCreamParlor {

    int[] icecreamParlor(int m, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < arr.length;  index++) {
            if (map.containsKey(m - arr[index])) {
                return new int[]{map.get(m- arr[index]), index + 1};
            } else {
                map.put(arr[index], index + 1);
            }
        }
        return new int[]{};
    }
}
