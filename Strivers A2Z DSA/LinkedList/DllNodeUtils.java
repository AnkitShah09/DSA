package LinkedList;

public class DllNodeUtils {

    public static void printLinkedList(DllNode head) {
        DllNode temp = head;
        while (temp != null) {
            System.out.printf("%d\t", temp.data);
            temp = temp.nextNode;
        }
        System.out.println("\n");
    }

    public static DllNode convertArrayToLinkedList(int[] arr, DllNode head) {
        for (int num : arr) {
            head = addNodeInLinkedList(num, head);
        }
        return head;
    }

    public static DllNode addNodeInLinkedList(int num, DllNode head) {
        DllNode node = new DllNode(num);
        if(head == null) {
            head = node;
        } else {
            DllNode temp = head;
            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }
            temp.nextNode = node;
            node.prevNode = temp;
        }
        return head;
    }
}
