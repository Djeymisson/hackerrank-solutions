package thirtydaysofcode;

import java.util.Scanner;

/*
 *   Day 24: More Linked Lists
 * */
public class TwentyFour {

    public static void removeDuplicates(Node head) {
        Node i = head;
        while (i != null && i.next != null) {
            while (i.next != null && i.next.data == i.data) i.next = i.next.next;
            i = i.next;
        }
    }

    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null) head = p;
        else if (head.next == null) head.next = p;
        else {
            Node start = head;
            while (start.next != null) start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int t = sc.nextInt();
        while (t-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        removeDuplicates(head);
        display(head);

    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

    }
}
