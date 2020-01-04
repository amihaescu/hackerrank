package ro.amihaescu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void PickingNumbers_Sample1() {
        assertEquals(3, solution.pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1)));
    }

    @Test
    void PickingNumbers_Sample2() {
        assertEquals(5, solution.pickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2)));
    }

    @Test
    void ClimbingLeaderBoard_Sample1() {
        int[] result = solution.climbingLeaderBoard(new int[]{100, 100, 50, 40, 40, 20, 10}, new int[]{5, 25, 50, 120});
        assertEquals(6, result[0]);
        assertEquals(4, result[1]);
        assertEquals(2, result[2]);
        assertEquals(1, result[3]);
    }

    @Test
    void ClimbingLeaderBoard_Sample2() {
        int[] result = solution.climbingLeaderBoard(new int[]{100, 90, 90, 80, 75, 60}, new int[]{50, 65, 77, 90, 102});
        assertEquals(6, result[0]);
        assertEquals(5, result[1]);
        assertEquals(4, result[2]);
        assertEquals(2, result[3]);
        assertEquals(1, result[4]);
    }

    @Test
    void testCondensedIntervals_TwoSequences() {
        int[] array = {1, 2, 4, 6, 7, 8, 9, 11};
        String expected = "1-2,4,6-9,11";

        String actual = solution.condenseArray(array);

        assertEquals(expected, actual);
    }

    @Test
    void testCondensedIntervals_OneSequence() {
        int[] array = {1, 6, 7, 8, 9};
        String expected = "1,6-9";

        String actual = solution.condenseArray(array);

        assertEquals(expected, actual);
    }

    @Test
    void testCondensedIntervals_OnlyOneSequence() {
        int[] array = {6, 7, 8, 9};
        String expected = "6-9";

        String actual = solution.condenseArray(array);

        assertEquals(expected, actual);
    }

    @Test
    void testCondensedIntervals_NoSequence() {
        int[] array = {1, 3, 5, 7};
        String expected = "1,3,5,7";

        String actual = solution.condenseArray(array);

        assertEquals(expected, actual);
    }

    @Test
    void rotateLeft_TestCase1() {
        int[] a = {1, 2, 3, 4, 5};
        int[] b= solution.rotLeft(a, 4);
        assertEquals(5, b[0]);
    }
    @Test
    void isBalanced_TestCase1() {
        assertEquals("YES", Solution.isBalanced("{[()]}"));
    }
    @Test
    void isBalanced_TestCase2() {
        assertEquals("NO", Solution.isBalanced("{[(])}"));
    }
    @Test
    void isBalanced_TestCase3() {
        assertEquals("YES", Solution.isBalanced("{{[[(())]]}}"));
    }

    @Test
    void isBalanced_TestCase4() {
        assertEquals("NO", Solution.isBalanced("[]][{]{(({{)[})(}[[))}{}){[{]}{})()[{}]{{]]]){{}){({(}](({[{[{)]{)}}}({[)}}([{{]]({{"));
    }
}
