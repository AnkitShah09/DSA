package LinkedList.Medium;

import LinkedList.Node;
import LinkedList.NodeUtils;

import java.util.Stack;

/*
    Coding platform Link: https://leetcode.com/problems/palindrome-linked-list/description/
    Striver's link: https://takeuforward.org/data-structure/check-if-given-linked-list-is-plaindrome/
    Solution Link: https://youtu.be/lRY_G-u_8jk
*/
public class CheckIfTheGivenLinkedListIsPalindrome {

    public static void main(String[] args) {

        Node head = null;

        int[] arr = {1, 2, 3, 3, 2, 1};
        head = NodeUtils.convertArrayToLinkedList(arr, head);
        NodeUtils.printLinkedList(head);

        boolean isPalindrome = isPalindromeLinkedList(head);
        System.out.printf("Is linked list a palindrome?: %s\n", isPalindrome);
    }

    private static boolean isPalindromeLinkedList(Node head) {

        if(head == null || head.nextNode == null) {
            return true;
        }

        boolean isPalindrome = true;

        // BRUTE-FORCE APPROACH
//        Stack<Integer> stack = new Stack<>();
//        Node temp = head;
//        while (temp != null) {
//            stack.push(temp.data);
//            temp = temp.nextNode;
//        }
//        temp = head;
//        while (temp != null) {
//            if(stack.pop() != temp.data) {
//                return false;
//            }
//            temp = temp.nextNode;
//        }

        // OPTIMAL APPROACH
        // 1. Try to find the middle element, so we can divide the list into 2.
        Node sP = head;
        Node fP = head;

        while (fP.nextNode!=null && fP.nextNode.nextNode!=null) {
            sP = sP.nextNode;
            fP = fP.nextNode.nextNode;
        }
        // 1st half: head -> sP, 2nd half: sP.nextNode -> null

        System.out.printf("Middle node: %d\n", sP.data);

        // 2. reverse the 2nd half temporarily.
        Node revHead = reverseList(sP.nextNode);

        // 3. compare both the lists.
        Node temp1 = head;
        Node temp2 = revHead;

        while (temp2!=null) {
            if(temp1.data != temp2.data) {
                isPalindrome = false;
                break;
            }
            temp1 = temp1.nextNode;
            temp2 = temp2.nextNode;
        }

        // 4. reverse the 2nd half to make the original list.
        reverseList(revHead);

        return isPalindrome;
    }

    private static Node reverseList(Node head) {

        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


}
