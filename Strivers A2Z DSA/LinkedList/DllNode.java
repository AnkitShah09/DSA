public class DllNode {
    int data;
    DllNode nextNode;
    DllNode prevNode;


    public DllNode(int data) {
        this.data = data;
        this.nextNode = null;
        this.prevNode = null;
    }

    public DllNode(int data, DllNode nextNode, DllNode prevNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }
}