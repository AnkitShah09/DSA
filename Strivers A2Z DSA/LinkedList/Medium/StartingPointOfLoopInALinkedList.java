package LinkedList.Medium;

import LinkedList.Node;

import java.util.LinkedHashMap;
import java.util.Map;

/*
    Coding platform Link: https://leetcode.com/problems/linked-list-cycle-ii/description/
    Striver's link: https://takeuforward.org/data-structure/starting-point-of-loop-in-a-linked-list/
    Solution Link: https://youtu.be/wiOo4DC5GGA
*/
public class StartingPointOfLoopInALinkedList {

    public static void main(String[] args) {

//        Node head = null;

        int[] arr = {1, 2, 3, 4, 5};
        Node head = new Node(1);
        head.nextNode = new Node(2);
        head.nextNode.nextNode = new Node(3);
        head.nextNode.nextNode.nextNode = new Node(4);
        head.nextNode.nextNode.nextNode.nextNode = new Node(5);
        head.nextNode.nextNode.nextNode.nextNode.nextNode = head.nextNode.nextNode;

        Node node = startingPointOfLoop(head);
        System.out.println("Loop starting point node: " + (node!=null ? node.data : null));
    }

    private static Node startingPointOfLoop(Node head) {

        // BRUTE-FORCE APPROACH
//        Map<Node, Integer> nodeVisitCountMap = new LinkedHashMap<>();
//        Node temp = head;
//        while (temp != null) {
//            if(nodeVisitCountMap.containsKey(temp)) {
//                return temp;
//            }
//            nodeVisitCountMap.put(temp, 1);
//            temp = temp.nextNode;
//        }

        // OPTIMAL APPROACH - Tortoise and Hare Algorithm
        Node sP = head;
        Node fP = head;

        boolean isLoopDetected = false;
        while (fP!=null && fP.nextNode!=null) {
            sP = sP.nextNode;
            fP = fP.nextNode.nextNode;

            if(sP == fP) {
                isLoopDetected = true;
                break;
            }
        }

        if(isLoopDetected) {
            sP = head;
            while (sP != fP) {
                sP = sP.nextNode;
                fP = fP.nextNode;
            }
            return sP;
        }

        return null;
    }
}
