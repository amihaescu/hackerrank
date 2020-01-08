package ro.amihaescu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BFSTest {

    @Test
    public void TestCase_One(){
        int[] distances = BFS.bfs(5, 6, new int[][]{
                {1,2},
                {2,3},
                {1,3},
                {1,5},
                {5,3},
                {3,4}
        }, 1);
        assertEquals(4, distances.length);
    }

    @Test
    public void TestCase_Two(){
        int[] distances = BFS.bfs(4, 2, new int[][]{
                {1,2},
                {1,3}
        }, 1);
        assertEquals(3, distances.length);

    }
}
