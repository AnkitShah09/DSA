public class NodeUtils {

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.printf("%d\t", temp.data);
            temp = temp.nextNode;
        }
        System.out.println("\n");
    }

    public static Node convertArrayToLinkedList(int[] arr, Node head) {
        for (int num : arr) {
            head = addNodeInLinkedList(num, head);
        }
        return head;
    }

    public static Node addNodeInLinkedList(int num, Node head) {
        Node node = new Node(num);
        if(head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }
            temp.nextNode = node;
        }
        return head;
    }
}
