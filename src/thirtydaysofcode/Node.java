package thirtydaysofcode;

/*
*   Node class for challenges 22 and 23
* */
class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
