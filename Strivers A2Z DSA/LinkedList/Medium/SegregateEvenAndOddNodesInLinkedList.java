package LinkedList.Medium;

import LinkedList.Node;
import LinkedList.NodeUtils;

import java.util.ArrayList;
import java.util.List;

/*
    Coding platform Link: https://leetcode.com/problems/odd-even-linked-list/description/
    Striver's link: https://takeuforward.org/data-structure/segregate-even-and-odd-nodes-in-linkedlist
*/
public class SegregateEvenAndOddNodesInLinkedList {

    public static void main(String[] args) {

        Node head = null;

        int[] arr = {2, 3, 1, 4, 5}; // {1, 2, 3, 4, 5, 6, 7, 8}, {2, 3, 1, 4, 5}
        head = NodeUtils.convertArrayToLinkedList(arr, head);
        NodeUtils.printLinkedList(head);

        head = segregateEvenAndOddNodes(head);
        NodeUtils.printLinkedList(head);
    }

    private static Node segregateEvenAndOddNodes(Node head) {

        if(head == null || head.nextNode == null) {
            return head;
        }

        // BRUTE-FORCE APPROACH
//        List<Integer> evenIndexNumbers = new ArrayList<>();
//        List<Integer> oddIndexNumbers = new ArrayList<>();
//        Node temp = head;
//        int index = 1;
//        while (temp != null) {
//            if(index%2 == 0) {
//                evenIndexNumbers.add(temp.data);
//            } else {
//                oddIndexNumbers.add(temp.data);
//            }
//            temp = temp.nextNode;
//            index++;
//        }
//        temp = head;
//
//        for (Integer oddIndexNum : oddIndexNumbers) {
//            temp.data = oddIndexNum;
//            temp = temp.nextNode;
//        }
//        for (Integer evenIndexNum : evenIndexNumbers) {
//            temp.data = evenIndexNum;
//            temp = temp.nextNode;
//        }

        System.out.println();
        // OPTIMAL APPROACH
        Node oddLL = head;
        Node evenLL = head.nextNode;
        Node evenLLHead = head.nextNode;
        while (evenLL!=null && evenLL.nextNode!=null) {
            // 1. Change the links for the odd nodes
            oddLL.nextNode = oddLL.nextNode.nextNode;
            oddLL = oddLL.nextNode;

            // 2. Change the links for the even nodes
            evenLL.nextNode = evenLL.nextNode.nextNode;
            evenLL = evenLL.nextNode;
        }

        // 3. Change the link from last odd node to first even node
        oddLL.nextNode = evenLLHead;

        return head;
    }

}
