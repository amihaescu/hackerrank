package ro.amihaescu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpingCloudsTest {

    @Test
    void TestCase_One() {
        assertEquals(4, JumpingClouds.jumpingOnClouds(new int[]{0,0,1,0,0,1,0}));
    }

    @Test
    void TestCase_Two() {
        assertEquals(3, JumpingClouds.jumpingOnClouds(new int[]{0,0,0,0,1, 0}));
    }
}
