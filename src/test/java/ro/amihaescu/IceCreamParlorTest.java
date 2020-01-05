package ro.amihaescu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IceCreamParlorTest {

    private IceCreamParlor iceCreamParlor = new IceCreamParlor();

    @Test
    void testCase_One(){
        int[] result = iceCreamParlor.icecreamParlor(4, new int[]{1,4,5,3,2});
        assertEquals(2, result.length);
        assertEquals(1, result[0]);
        assertEquals(4, result[1]);
    }


    @Test
    void testCase_Two(){
        int[] result = iceCreamParlor.icecreamParlor(4, new int[]{2,2,4,3});
        assertEquals(2, result.length);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }

}
