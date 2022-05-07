package ro.amihaescu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeCheckTest {

    /*
       invalid case
        8
        |\
        5 9
        |\
        2 6
           \
            4
    */
    @Test
    public void should_not_be_a_BST_refined_case() {
        BinaryTreeCheck.Node root = new BinaryTreeCheck.Node(8);
        BinaryTreeCheck.Node child_one = new BinaryTreeCheck.Node(5);
        BinaryTreeCheck.Node child_two = new BinaryTreeCheck.Node(9);
        BinaryTreeCheck.Node child_one_one = new BinaryTreeCheck.Node(2);
        BinaryTreeCheck.Node child_one_two = new BinaryTreeCheck.Node(6);
        BinaryTreeCheck.Node child_one_two_two = new BinaryTreeCheck.Node(4);
        root.setLeft(child_one);
        root.setRight(child_two);
        child_one.setLeft(child_one_one);
        child_one.setRight(child_one_two);
        child_one_two.setRight(child_one_two_two);
        assertFalse(BinaryTreeCheck.isBST(root));
    }

    /*
       not a BST
        8
        |\
       10 9
        |\
        1 2

    */
    @Test
    public void should_not_be_a_bst() {
        BinaryTreeCheck.Node root = new BinaryTreeCheck.Node(8);
        BinaryTreeCheck.Node child_one = new BinaryTreeCheck.Node(10);
        BinaryTreeCheck.Node child_two = new BinaryTreeCheck.Node(9);
        BinaryTreeCheck.Node child_one_one = new BinaryTreeCheck.Node(1);
        BinaryTreeCheck.Node child_one_two = new BinaryTreeCheck.Node(2);
        root.setLeft(child_one);
        root.setRight(child_two);
        child_one.setLeft(child_one_one);
        child_one.setRight(child_one_two);
        assertFalse(BinaryTreeCheck.isBST(root));
    }
}
