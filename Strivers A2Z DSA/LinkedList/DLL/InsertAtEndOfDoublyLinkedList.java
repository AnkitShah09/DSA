package LinkedList.DLL;

import LinkedList.DllNode;
import LinkedList.DllNodeUtils;

/*
    Coding platform Link: https://www.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1
    Striver's link: https://takeuforward.org/data-structure/insert-at-end-of-doubly-linked-list/
    Solution Link: https://youtu.be/0eKMU10uEDI
*/
public class InsertAtEndOfDoublyLinkedList {

    public static void main(String[] args) {

        DllNode head = null;
        int[] arr = {12, 8, 5, 7};

        head = DllNodeUtils.convertArrayToLinkedList(arr, head);
        DllNodeUtils.printLinkedList(head);

        head = insertAtEnd(45, head);
        DllNodeUtils.printLinkedList(head);
    }

    public static DllNode insertAtEnd(int num, DllNode head) {
        DllNode node = new DllNode(num);
        if(head == null) {
            head = node;
        } else {
            DllNode temp = head;
            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }
            temp.nextNode = node;
            node.prevNode = temp;
        }
        return head;
    }

}
