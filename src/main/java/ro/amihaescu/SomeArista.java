package ro.amihaescu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SomeArista {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     * - itterate throught the matrix
     * -  cat, catan, mouse, cut
     * 0
     * |\ \
     * c m
     * |\
     * a u
     * | |
     * t t
     * |
     * a
     * |
     * n
     */
    public static void solve(List<String> dict, char[][] matrix) {
        Node rootNode = parseToThree(dict);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                var letter = matrix[i][j];
                var optionalChild = rootNode.getChild(letter);
                if (optionalChild.isEmpty()) {
                    continue;
                } else {
                    var child = optionalChild.get();
                    for (int k = -1; k < 2; k++) {
                        for (int l = -1; l < 2; l++) {
                            if (k != 0 && l != 0) {
                                var potentialChild = child.getChild(matrix[i + k][j + l]);
                                if (potentialChild.isEmpty()) {
                                    continue;
                                } else {
                                    // set direction to k,l -> i+k, j+l
                                    // itterate adding k,l until tree is empty or reached limits
                                    // print word if isLast == true

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Node parseToThree(List<String> dict) {
        Node rootNode = new Node(' ', false);
        for (String word : dict) {
            Node node = rootNode;
            for (int i = 0; i < word.length(); i++) {
                Character letter = word.charAt(i);
                var optionalChild = node.getChild(letter);
                if (optionalChild.isEmpty()) {
                    var childNode = new Node(letter, i == word.length() - 1);
                    node.addChild(childNode);
                    node = childNode;
                } else {
                    node = optionalChild.get();
                }
            }
        }
        return rootNode;
    }
}


class Node {


    Character value;
    Boolean isLast;
    Map<Character, Node> nodes;
    public Node(Character value, Boolean isLast) {
        this.value = value;
        this.isLast = isLast;
    }

    void addChild(Node node) {
        nodes.put(node.value, node);
    }

    Optional<Node> getChild(Character c) {
        return Optional.ofNullable(nodes.get(c));
    }
}
