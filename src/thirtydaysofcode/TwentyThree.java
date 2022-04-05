package thirtydaysofcode;

import java.util.*;

/*
 *   Day 23: BST Level-Order Traversal
 * */
class TwentyThree {

    static void levelOrder(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        byLevel(map, root, 1);

        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : map.values()) {
            for (Integer i : list) {
                sb.append(i);
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }

    private static void byLevel(Map<Integer, List<Integer>> map, Node root, int level) {
        if (root == null) return;

        map.computeIfAbsent(level, integer -> new ArrayList<>()).add(root.data);

        byLevel(map, root.left, ++level);
        byLevel(map, root.right, ++level);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }
}
