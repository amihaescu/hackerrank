package ro.amihascu;

import org.junit.jupiter.api.Test;
import ro.amihaescu.Solution;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals(3, solution.pickingNumbers(Arrays.asList(4,6,5,3,3,1)));
    }

    @Test
    void test2() {
        assertEquals(5, solution.pickingNumbers(Arrays.asList(1,2,2,3,1,2)));
    }
}
