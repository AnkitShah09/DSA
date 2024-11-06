package LinkedList.Medium;

import LinkedList.Node;
import LinkedList.NodeUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/*
    Coding platform Link: https://www.geeksforgeeks.org/problems/find-length-of-loop/1
    Striver's link: https://takeuforward.org/linked-list/length-of-loop-in-linked-list
    Solution Link: https://youtu.be/I4g1qbkTPus
*/
public class LengthOfLoopInLinkedList {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        Node head = new Node(1);
        head.nextNode = new Node(2);
        head.nextNode.nextNode = new Node(3);
        head.nextNode.nextNode.nextNode = new Node(4);
        head.nextNode.nextNode.nextNode.nextNode = new Node(5);
        head.nextNode.nextNode.nextNode.nextNode.nextNode = new Node(6);
        head.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode = new Node(7);
        head.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode = new Node(8);
        head.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode = new Node(9);
        head.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode = head.nextNode.nextNode;

        int length = lengthOfLoop(head);
        System.out.printf("Length of loop: %d", length);
    }

    private static int lengthOfLoop(Node head) {
        // BRUTE-FORCE APPROACH
//        Map<Node, Integer> nodeVisitCountMap = new LinkedHashMap<>();
//        Node temp = head;
//        int count = 1;
//        while (temp != null) {
//            if(nodeVisitCountMap.containsKey(temp)) {
//                System.out.printf("Loop detected at node: %d\n", temp.data);
//                return (count-nodeVisitCountMap.get(temp));
//            }
//            nodeVisitCountMap.put(temp, count++);
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
            int counter = 1;
            fP = fP.nextNode;
            while (sP != fP) {
                fP = fP.nextNode;
                counter++;
            }
            return counter;
        }

        return 0;
    }

}
