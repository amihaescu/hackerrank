package ro.amihaescu;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.Arrays.binarySearch;
import static java.util.stream.IntStream.range;

public class Solution {

    String condenseArray(int[] array) {
        boolean isSequence = false;
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < array.length; index++) {
            int diff = diff(array, index);
            if (diff != 1 && !isSequence) {
                sb.append(array[index]);
                if (index != array.length - 1) sb.append(",");
            } else if (diff == 1 && !isSequence) {
                isSequence = true;
                sb.append(array[index]).append("-");
            } else if (diff != 1) {
                sb.append(array[index]);
                if (index != array.length - 1) sb.append(",");
                isSequence = false;
            }
        }
        return sb.toString();
    }

    private static int diff(int[] array, int position) {
        if (position == array.length - 1)
            return -1;
        return array[position + 1] - array[position];
    }

    int pickingNumbers(List<Integer> list) {
        return list.stream()
                .mapToInt(integer -> Collections.frequency(list, integer) + Collections.frequency(list, integer + 1))
                .max().orElse(0);
    }

    int[] climbingLeaderBoard(int[] scores, int[] alice) {
        int[] positions = new int[alice.length];
        int[] array = range(0, scores.length).map(i -> scores[scores.length - i - 1]).distinct().toArray();
        int index = 0;
        for (int scoreIndex = 0; scoreIndex < alice.length; scoreIndex++) {
            index = binarySearch(array, Math.max(index, 0), array.length, alice[scoreIndex]);
            if (index < 0) index = -index - 2;
            positions[scoreIndex] = array.length - index;
        }
        return positions;
    }

    static int designerPdfViewer(int[] h, String word) {
        return word.length() * word.chars().map(operand -> h[operand - 97]).max().orElse(-1);
    }

    int[] rotLeft(int[] a, int d) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[(i + d) % a.length];
        }
        return b;
    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (position == 0) {
            newNode.next = head;
            return newNode;
        }
        SinglyLinkedListNode originalHead = head;
        int counter = 0;
        while (head.next != null && counter++ < position - 1)
            head = head.next;
        newNode.next = head.next;
        head.next = newNode;
        return originalHead;
    }

    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null) return false;
        Set<SinglyLinkedListNode> set = new HashSet<>();
        while (head.next != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');
        for (Character character : s.toCharArray()) {
            if (pairs.containsValue(character)) {
                if (!stack.isEmpty() && pairs.get(stack.peek()).equals(character))
                    stack.pop();
                else {
                    return "NO";
                }
            } else {
                stack.push(character);
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
}
