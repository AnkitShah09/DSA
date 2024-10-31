package LinkedList.Easy;

import LinkedList.Node;
import LinkedList.NodeUtils;

/*
    Coding platform Link: https://www.geeksforgeeks.org/problems/linked-list-insertion-1587115620/0
    Striver's link: https://takeuforward.org/linked-list/insert-at-the-head-of-a-linked-list
    Solution Link: https://youtu.be/VaECK03Dz-g
*/
public class InsertAtTheHeadOfALinkedList {

    public static void main(String[] args) {

        Node head = null;

        int[] arr = {12, 8, 5, 7};
        head = NodeUtils.convertArrayToLinkedList(arr, head);
        NodeUtils.printLinkedList(head);

        int num = 10;
        head = insertNodeAtHeadOfLinkedList(num, head);
        NodeUtils.printLinkedList(head);
    }

    private static Node insertNodeAtHeadOfLinkedList(int num, Node head) {

        Node node = new Node(num);
        node.nextNode = head;
        head = node;
        return head;
    }

}
