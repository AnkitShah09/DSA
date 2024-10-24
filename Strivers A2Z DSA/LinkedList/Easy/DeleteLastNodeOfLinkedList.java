/*
    Coding platform Link: https://leetcode.com/problems/delete-node-in-a-linked-list/description/
    Striver's link: https://takeuforward.org/data-structure/delete-last-node-of-linked-list/
    Solution Link: https://youtu.be/VaECK03Dz-g
*/
public class DeleteLastNodeOfLinkedList {

    public static void main(String[] args) {

        Node head = null;

        int[] arr = {12, 8, 5, 7};
        head = NodeUtils.convertArrayToLinkedList(arr, head);
        NodeUtils.printLinkedList(head);

        head = deleteTail(head);
        NodeUtils.printLinkedList(head);
    }

    private static Node deleteTail(Node head) {
        if(head == null || head.nextNode == null) {
            return null;
        }

        Node temp = head;
        while (temp.nextNode.nextNode != null) {
            temp = temp.nextNode;
        }
        temp.nextNode = null;

        return head;
    }

}
