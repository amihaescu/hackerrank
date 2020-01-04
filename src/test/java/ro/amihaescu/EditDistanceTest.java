package ro.amihaescu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditDistanceTest {

    private EditDistance editDistance;

    @BeforeEach
    void setUp() {
        editDistance = new EditDistance();
    }

    @Test
    void testCase_One() {
        assertFalse(editDistance.oneEditApart("cat", "dog"));
    }

    @Test
    void testCase_Two() {
        assertTrue(editDistance.oneEditApart("cat", "cats"));
    }

    @Test
    void testCase_Three() {
        assertTrue(editDistance.oneEditApart("cat", "cut"));
    }

    @Test
    void testCase_Four() {
        assertTrue(editDistance.oneEditApart("cat", "cast"));
    }

    @Test
    void testCase_Five() {
        assertTrue(editDistance.oneEditApart("cat", "at"));
    }

    @Test
    void testCase_Six() {
        assertFalse(editDistance.oneEditApart("cat", "act"));
    }
}
