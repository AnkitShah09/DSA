package LinkedList.Medium;

import LinkedList.Node;
import LinkedList.NodeUtils;

/*
    Coding platform Link: https://leetcode.com/problems/middle-of-the-linked-list/description/
    Striver's link: https://takeuforward.org/data-structure/find-middle-element-in-a-linked-list/
    Solution Link: https://youtu.be/7LjQ57RqgEc
*/
public class FindMiddleElementInALinkedList {

    public static void main(String[] args) {

        Node head = null;

        int[] arr = {12, 8, 5, 7, 43, 54, 3, 78};
        head = NodeUtils.convertArrayToLinkedList(arr, head);
        NodeUtils.printLinkedList(head);

        int num = findMiddleElement(head);
        System.out.printf("Middle element: %d", num);
    }

    private static int findMiddleElement(Node head) {
        if(head == null) {
            return -1;
        }
        Node middle;

        // BRUTE FORCE APPROACH
//        Node temp = head;
//        int counter = 0;
//
//        while (temp!=null) {
//            counter++;
//            temp = temp.nextNode;
//        }
//        int middleIndex = counter/2;
//        counter = 0;
//        temp = head;
//        while (temp != null) {
//            if(counter == middleIndex) {
//                break;
//            }
//            counter++;
//            temp = temp.nextNode;
//        }
//        middle = temp;

        // OPTIMAL SOLUTION - Tortoise and Hare Algorithm
        Node sP = head;
        Node fP = head;

        while (fP!=null && fP.nextNode!=null) {
            sP = sP.nextNode;
            fP = fP.nextNode.nextNode;
        }
        middle = sP;

        return middle.data;
    }
}
