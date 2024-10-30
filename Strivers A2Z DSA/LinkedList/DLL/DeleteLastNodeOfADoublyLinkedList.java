/*
    Coding platform Link: https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1
    Striver's link: https://takeuforward.org/data-structure/delete-last-node-of-a-doubly-linked-list/
    Solution Link: https://youtu.be/0eKMU10uEDI
*/
public class DeleteLastNodeOfADoublyLinkedList {

    public static void main(String[] args) {

        DllNode head = null;
        int[] arr = {12, 8, 5, 7};

        head = DllNodeUtils.convertArrayToLinkedList(arr, head);
        DllNodeUtils.printLinkedList(head);

        head = deleteLastNode(head);
        DllNodeUtils.printLinkedList(head);
    }

    private static DllNode deleteLastNode(DllNode head) {
        if(head == null || head.nextNode == null) {
            return null;
        }
        DllNode temp = head;
        while (temp.nextNode != null) {
            temp = temp.nextNode;
        }
        temp = temp.prevNode;
        temp.nextNode.prevNode = null;
        temp.nextNode = null;
        return head;
    }
}
