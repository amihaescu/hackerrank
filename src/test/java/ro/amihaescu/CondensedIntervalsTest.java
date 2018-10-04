package ro.amihaescu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ro.amihaescu.CondensedIntervals.condenseArray;

public class CondensedIntervalsTest {

    @Test
    void testCondensedIntervals_TwoSequences(){
        int[] array = {1,2,4,6,7,8,9,11};
        String expected = "1-2,4,6-9,11";

        String actual = condenseArray(array);

        assertEquals(expected, actual);
    }

    @Test
    void testCondensedIntervals_OneSequence(){
        int[] array = {1,6,7,8,9};
        String expected = "1,6-9";

        String actual = condenseArray(array);

        assertEquals(expected, actual);
    }

    @Test
    void testCondensedIntervals_OnlyOneSequence(){
        int[] array = {6,7,8,9};
        String expected = "6-9";

        String actual = condenseArray(array);

        assertEquals(expected, actual);
    }

    @Test
    void testCondensedIntervals_NoSequence(){
        int[] array = {1,3,5,7};
        String expected = "1,3,5,7";

        String actual = condenseArray(array);

        assertEquals(expected, actual);
    }
}
