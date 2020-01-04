package ro.amihaescu;

import java.util.Arrays;

public class VeryBigSum {

    static long aVeryBigSum(long[] ar) {
        return Arrays.stream(ar).sum();
    }

}
