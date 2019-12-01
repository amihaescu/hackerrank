package ro.amihaescu;

import java.util.Collections;
import java.util.List;

public class Solution {

    public int pickingNumbers(List<Integer> list) {
        return list.stream()
                .mapToInt(integer -> Collections.frequency(list, integer) + Collections.frequency(list, integer + 1))
                .max().orElse(0);
    }
}
