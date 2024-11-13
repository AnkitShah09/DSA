package LinkedList.Medium;

import LinkedList.Node;
import LinkedList.NodeUtils;

/*
    Coding platform Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
    Striver's link: https://takeuforward.org/data-structure/remove-n-th-node-from-the-end-of-a-linked-list/
*/
public class RemoveNthNodeFromTheEndOfALinkedList {

    public static void main(String[] args) {

        Node head = null;

        int[] arr = {1, 2, 3, 4, 5}; // {1, 2, 3, 4, 5}
        head = NodeUtils.convertArrayToLinkedList(arr, head);
        NodeUtils.printLinkedList(head);

        int n = 1;
        head = removeNthNodeFromTheEnd(head, n);
        NodeUtils.printLinkedList(head);
    }

    private static Node removeNthNodeFromTheEnd(Node head, int n) {

        if(head == null || (head.nextNode == null && n==1)) {
            return null;
        }

        // BRUTE-FORCE APPROACH
//        Node temp = head;
//
//        // Remove tail
//        if(n == 1) {
//            while (temp.nextNode != null && temp.nextNode.nextNode != null) {
//                temp = temp.nextNode;
//            }
//            temp.nextNode = null;
//            return head;
//        }
//
//        int size = 0;
//        while (temp!=null) {
//            size++;
//            temp = temp.nextNode;
//        }
//
//        // Remove head
//        if(n == size) {
//            temp = head;
//            head = head.nextNode;
//            temp.nextNode = null;
//            return head;
//        }
//
//        int s=size-n+1;
//        int i=1;
//        Node prev = null;
//        Node current = head;
//        while (current!=null) {
//            if(i==s) {
//                prev.nextNode = current.nextNode;
//                current.nextNode = null;
//                break;
//            }
//            i++;
//            prev = current;
//            current = current.nextNode;
//        }

        // OPTIMAL APPROACH
        Node sP = head;
        Node fP = head;

        for(int i=0; i<n; i++) {
            fP = fP.nextNode;
        }

        // delete head
        if(fP == null) {
            Node temp = head;
            head = head.nextNode;
            temp.nextNode = null;
            return head;
        }

        while (fP.nextNode != null) {
            sP = sP.nextNode;
            fP = fP.nextNode;
        }

        Node temp = sP.nextNode;
        sP.nextNode = temp.nextNode;
        temp.nextNode = null;

        return head;
    }

}
