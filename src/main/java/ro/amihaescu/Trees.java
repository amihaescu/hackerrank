package ro.amihaescu;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Trees {

    static class Node {
        Node right, left;
        private int data;

        public Node(int data) {
            this.data = data;
        }

        public void add(int value) {
            if (value <= this.data) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.add(value);
                }
            } else {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.add(value);
                }
            }
        }

        public boolean contains(int value) {
            if (data == value) {
                return true;
            } else {
                if (value <= data) {
                    if (left == null) {
                        return false;
                    } else {
                        return left.contains(data);
                    }
                } else {
                    if (right == null) {
                        return false;
                    } else {
                        return right.contains(data);
                    }
                }
            }
        }

        public void inOrder() {
            if (left != null) {
                left.inOrder();
            }
            System.out.printf("%d ", data);
            if (right != null) {
                right.inOrder();
            }
        }
    }

    public double[] averagePerLevel(Node node, Integer depth, Map<Integer, Set<Integer>> map) {
        recurseTree(node, depth, map);
        int index = 0;
        double[] result = new double[map.keySet().size()];
        for (Set<Integer> set : map.values()){
            result[index++] = set.stream().mapToInt(Integer::intValue).average().getAsDouble();
        }
        return result;
    }

    private void recurseTree(Node node, Integer depth, Map<Integer, Set<Integer>> map) {
        Set<Integer> levelSet = map.get(depth);
        if (levelSet == null) {
            Set<Integer> integerSet = new HashSet<>();
            integerSet.add(node.data);
            map.put(depth, integerSet);
        } else {
            map.get(depth).add(node.data);
        }

        if (node.right == null && node.left == null) {
            return;
        }

        if (node.left != null) {
            averagePerLevel(node.left,depth + 1, map);
        }

        if (node.right != null){
            averagePerLevel(node.right,depth + 1, map);
        }
    }

    public static int height(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));

    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.add(2);
        root.add(1);
        root.add(5);
        root.add(4);
        root.add(6);
        root.add(7);
        System.out.println("Height: " + height(root));
        //root.inOrder();
        //System.out.printf("\nContains 8: %s", root.contains(8));

    }

}
