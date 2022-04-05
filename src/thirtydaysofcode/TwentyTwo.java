package thirtydaysofcode;

import java.util.Scanner;

/*
 *   Day 22: Binary Search Trees
 * */
class TwentyTwo {

    public static int getHeight(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static Node insert(Node root, int data) {
        if (root == null) return new Node(data);

        if (data <= root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }
}

