package ro.amihaescu;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreesTest {

    Trees trees = new Trees();

    @Test
    void averageTest(){
        Trees.Node root = new Trees.Node(4);
        Trees.Node leftLvlOne = new Trees.Node(7);
        Trees.Node rightLvlOne = new Trees.Node(9);
        root.left = leftLvlOne;
        root.right = rightLvlOne;
        Trees.Node rightLvlTwo = new Trees.Node(2);
        leftLvlOne.left = new Trees.Node(10);
        leftLvlOne.right = rightLvlTwo;
        Trees.Node rightLvlThree = new Trees.Node(6);
        rightLvlTwo.right = rightLvlThree;
        rightLvlThree.right = new Trees.Node(2);
        rightLvlOne.right = new Trees.Node(6);

        Map<Integer, Set<Integer>> map = new HashMap<>();
        double[] result = trees.averagePerLevel(root, 0,map);
        assertEquals(5, result.length);
    }
}
