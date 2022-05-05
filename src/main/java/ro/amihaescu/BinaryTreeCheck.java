package ro.amihaescu;

/**
 * give a tree, validate if it's a binary search tree
 */
public class BinaryTreeCheck {

    public static boolean isBST(Node root) {
        if (root.left == null && root.right == null) return false;
        var isLess = validateLeftbBranch(root.left, root.value);
        var isGreater = validateRightBranch(root.right, root.value);
        return isLess && isGreater;
    }

    private static boolean validateRightBranch(Node node, int value) {
        if (node.left == null && node.right == null) return node.value > value;
        if (node.left == null) {
            return node.value > value && validateRightBranch(node.right, node.value);
        }
        if (node.right == null) {
            return node.value > value && validateLeftbBranch(node.left, node.value);
        } else
            return node.value > value && validateLeftbBranch(node.left, node.value) && validateRightBranch(node.right, node.value);
    }

    private static boolean validateLeftbBranch(Node node, int value) {
        if (node.left == null && node.right == null) return node.value < value;
        if (node.left == null) {
            return node.value < value && validateRightBranch(node.right, node.value);
        }
        if (node.right == null) {
            return node.value < value && validateLeftbBranch(node.left, node.value);
        } else
            return node.value < value && validateLeftbBranch(node.left, node.value) && validateRightBranch(node.right, node.value);
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }


}
