package ro.amihaescu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RepeatedString {

    static long repeatedString(String s, long n) {
        if (!s.contains("a")) {
            return 0;
        }
        int c = count(s, s.length());
        long remainder = n % s.length();
        long times = n / s.length() * c;
        times += count(s, remainder);
        return times;
    }

    private static int count(String s, long n ) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        repeatedString("a", 1000000000000L);
    }
}
