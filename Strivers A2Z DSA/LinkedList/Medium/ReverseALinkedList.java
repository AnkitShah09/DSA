package LinkedList.Medium;

import LinkedList.Node;
import LinkedList.NodeUtils;

/*
    Coding platform Link: https://leetcode.com/problems/reverse-linked-list/description/
    Striver's link: https://takeuforward.org/data-structure/reverse-a-linked-list/
    Solution Link: https://youtu.be/D2vI2DNJGd8
*/
public class ReverseALinkedList {

    public static void main(String[] args) {

        Node head = null;

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        head = NodeUtils.convertArrayToLinkedList(arr, head);
        NodeUtils.printLinkedList(head);

//        head = reverseALinkedListUsingIterativeApproach(head);
        head = reverseALinkedListUsingRecursiveApproach(head);
        NodeUtils.printLinkedList(head);
    }

    private static Node reverseALinkedListUsingRecursiveApproach(Node head) {
        Node newHead;
        if(head==null || head.nextNode==null) {
            return head;
        }

        newHead = reverseALinkedListUsingRecursiveApproach(head.nextNode);
        Node next = head.nextNode;
        next.nextNode = head;
        head.nextNode = null;

        return newHead;
    }

    private static Node reverseALinkedListUsingIterativeApproach(Node head) {
        if(head==null || head.nextNode==null) {
            return head;
        }

        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
        }
        head = prev;

        return head;
    }

}
