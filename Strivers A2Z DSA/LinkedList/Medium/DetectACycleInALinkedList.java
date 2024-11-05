package LinkedList.Medium;

import LinkedList.Node;

import java.util.LinkedHashMap;
import java.util.Map;

/*
    Coding platform Link: https://leetcode.com/problems/linked-list-cycle/description/
    Striver's link: https://takeuforward.org/data-structure/detect-a-cycle-in-a-linked-list/
    Solution Link: https://youtu.be/wiOo4DC5GGA
*/
public class DetectACycleInALinkedList {

    public static void main(String[] args) {

//        Node head = null;

        int[] arr = {1, 2, 3, 4, 5};
        Node head = new Node(1);
        head.nextNode = new Node(2);
        head.nextNode.nextNode = new Node(3);
        head.nextNode.nextNode.nextNode = new Node(4);
        head.nextNode.nextNode.nextNode.nextNode = new Node(5);
        head.nextNode.nextNode.nextNode.nextNode.nextNode = head.nextNode.nextNode;

        boolean isLoopDetected = isLoopDetected(head);
        System.out.printf("Is loop detected?: %s", isLoopDetected);
    }

    private static boolean isLoopDetected(Node head) {

        // BRUTE-FORCE APPROACH
//        Map<Node, Integer> nodeVisitCountMap = new LinkedHashMap<>();
//        Node temp = head;
//        while (temp != null) {
//            if(nodeVisitCountMap.containsKey(temp)) {
//                System.out.printf("Loop detected at node: %d\n", temp.data);
//                return true;
//            }
//            nodeVisitCountMap.put(temp, 1);
//            temp = temp.nextNode;
//        }

        // OPTIMAL APPROACH - Tortoise and Hare Algorithm
        Node sP = head;
        Node fP = head;

        while (fP!=null && fP.nextNode!=null) {
            sP = sP.nextNode;
            fP = fP.nextNode.nextNode;

            if(sP == fP) {
                return true;
            }
        }

        return false;
    }
}
