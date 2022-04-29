package advanced.visitorpattern;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

enum Color {
    RED, GREEN
}

interface TreeVis {
    int getResult();

    void visitNode(TreeNode node);

    void visitLeaf(TreeLeaf leaf);
}

abstract class Tree {

    private final int value;
    private final Color color;
    private final int depth;

    protected Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private final ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

// Editable below this line
class SumInLeavesVisitor implements TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        // do nothing
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor implements TreeVis {
    private long product = 1;

    public int getResult() {
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        checkAndUpdate(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        checkAndUpdate(leaf);
    }

    private void checkAndUpdate(Tree t) {
        if (t.getColor().equals(Color.RED)) product = (long) ((product * t.getValue()) % (Math.pow(10, 9) + 7));
    }
}

class FancyVisitor implements TreeVis {

    private int sumNonLeaf = 0;
    private int sumGreenLeaf = 0;

    public int getResult() {
        return Math.abs(sumGreenLeaf - sumNonLeaf);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) sumNonLeaf += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.GREEN)) sumGreenLeaf += leaf.getValue();
    }
}

public class Solution {

    private static final Map<Integer, Set<Integer>> edges = new HashMap<>();
    private static List<Integer> values;
    private static List<Color> colors;

    public static Tree solve() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            values = IntStream.range(0, n).map(i -> scanner.nextInt()).boxed().collect(toList());
            colors = IntStream.range(0, n).mapToObj(i -> scanner.nextInt() == 0 ? Color.RED : Color.GREEN).collect(toList());

            for (int i = 0; i < n - 1; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();

                // adding connection directed u -> v
                if (edges.containsKey(u)) {
                    edges.get(u).add(v);
                } else {
                    HashSet<Integer> vSet = new HashSet<>();
                    vSet.add(v);
                    edges.put(u, vSet);
                }

                // adding connection reversed v -> u
                if (edges.containsKey(v)) {
                    edges.get(v).add(u);
                } else {
                    HashSet<Integer> uSet = new HashSet<>();
                    uSet.add(u);
                    edges.put(v, uSet);
                }

            }

            if (n == 1) return new TreeLeaf(values.get(0), colors.get(0), 0);

            TreeNode root = new TreeNode(values.get(0), colors.get(0), 0);
            addChildren(root, 1);

            return root;
        }
    }

    public static void addChildren(TreeNode parentNode, int parentNumber) {
        Set<Integer> childrenNumbers = edges.get(parentNumber);

        for (Integer childNumber : childrenNumbers) {
            edges.get(childNumber).remove(parentNumber); // removing cycle, i.e. child pointing to parent

            Set<Integer> grandChildren = edges.get(childNumber);
            if (grandChildren.isEmpty()) // base case
                parentNode.addChild(new TreeLeaf(values.get(childNumber - 1), colors.get(childNumber - 1), parentNode.getDepth() + 1));
            else {
                TreeNode childNode = new TreeNode(values.get(childNumber - 1), colors.get(childNumber - 1), parentNode.getDepth() + 1);
                parentNode.addChild(childNode);
                addChildren(childNode, childNumber); // recursive step
            }
        }

    }

    // Non-editable below this line
    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
