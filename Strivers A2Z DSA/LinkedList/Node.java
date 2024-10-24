public class Node {
    int data;
    Node nextNode;

    public Node(int data) {
        this.data = data;
        this.nextNode = null;
    }

    public Node(int data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }
}