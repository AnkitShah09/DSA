package LinkedList.Medium;

import LinkedList.Node;
import LinkedList.NodeUtils;

/*
    Coding platform Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
    Striver's link: https://takeuforward.org/linked-list/delete-the-middle-node-of-the-linked-list
*/
public class DeleteTheMiddleNodeOfTheLinkedList {

    public static void main(String[] args) {

        Node head = null;

        int[] arr = {2, 1}; // {1, 2, 3, 4, 5}, {12, 8, 5, 7, 43, 54, 3, 78}, {2, 1}
        head = NodeUtils.convertArrayToLinkedList(arr, head);
        NodeUtils.printLinkedList(head);

        head = deleteMiddleNode(head);
        NodeUtils.printLinkedList(head);
    }

    private static Node deleteMiddleNode(Node head) {
        if(head == null || head.nextNode == null) {
            return head;
        }

        // OPTIMAL SOLUTION - Tortoise and Hare Algorithm
        Node prev = null;
        Node sP = head;
        Node fP = head;

        while (fP!=null && fP.nextNode!=null) {
            prev = sP;
            sP = sP.nextNode;
            fP = fP.nextNode.nextNode;
        }

        prev.nextNode = sP.nextNode;
        sP.nextNode = null;

        return head;
    }
}
