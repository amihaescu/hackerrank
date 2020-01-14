package ro.amihaescu;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ReverseDoublyLinkedList {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.println(node.data);

            node = node.next;

            if (node != null) {
                System.out.println(sep);
            }
        }
    }

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head.next == null) {
            head.next = head.prev;
            return head;
        }
        DoublyLinkedListNode oldNext = head.next;
        head.next = head.prev;
        return reverse(oldNext);
    }

    static int findMergeNode(Solution.SinglyLinkedListNode head1, Solution.SinglyLinkedListNode head2) {
        Solution.SinglyLinkedListNode current1 = head1;
        Solution.SinglyLinkedListNode current2 = head2;
        while (current1 != current2) {
            if (current1.next == null) {
                current1 = head2;
            } else {
                current1 = current1.next;
            }
            if (current2.next == null) {
                current2 = head1;
            } else {
                current2 = current2.next;
            }
        }
        return current2.data;

    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode currentNode = head;
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (head == null) {
            return newNode;
        } else if (data < currentNode.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        } else {
            DoublyLinkedListNode previousNode = null;
            while ( currentNode.data < data  && currentNode != null) {
                previousNode = currentNode;
                currentNode = currentNode.next;

            }
            previousNode.next = newNode;
            newNode.prev = previousNode;

            currentNode.prev = newNode;
            newNode.next = currentNode;

            return head;
        }

    }

    public static void main(String[] args) throws IOException {
        DoublyLinkedListNode node1 = new DoublyLinkedListNode(1);
        DoublyLinkedListNode node2 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode node3 = new DoublyLinkedListNode(3);
        DoublyLinkedListNode node4 = new DoublyLinkedListNode(4);
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.next = node3;
        sortedInsert(node1, 3);


    }
}
