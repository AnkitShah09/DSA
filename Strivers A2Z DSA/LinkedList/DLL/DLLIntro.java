/*
    Coding platform Link: https://www.geeksforgeeks.org/problems/introduction-to-doubly-linked-list/1
    Striver's link: https://takeuforward.org/linked-list/introduction-to-doubly-linked-list
    Solution Link: https://youtu.be/0eKMU10uEDI
*/
public class DLLIntro {

    public static void main(String[] args) {

        DllNode head = null;
        int[] arr = {12, 8, 5, 7};

        head = DllNodeUtils.convertArrayToLinkedList(arr, head);
        DllNodeUtils.printLinkedList(head);

//        head = DllNodeUtils.addNodeInLinkedList(9, head);
//        DllNodeUtils.printLinkedList(head);
//
//        head = deleteHeadOfDLL(head);
//        DllNodeUtils.printLinkedList(head);
//
//        head = deleteTailOfDLL(head);
//        DllNodeUtils.printLinkedList(head);
//
//        int k = 3;
//        head = deleteKthElementOfDLL(head, k);
//        DllNodeUtils.printLinkedList(head);

        head = deleteNode(head.nextNode);
        DllNodeUtils.printLinkedList(head);
    }

    private static DllNode deleteNode(DllNode node) {
        return null;
    }

    private static DllNode deleteKthElementOfDLL(DllNode head, int k) {

        DllNode temp = head;
        int counter = 0;

        while (temp != null) {
            counter++;
            if(counter == k) {
                break;
            }
            temp = temp.nextNode;
        }

        if(temp == null) {
            return null;
        }

        if(temp.prevNode == null && temp.nextNode == null) {
            return null;
        } else if (temp.prevNode == null) {
            return deleteHeadOfDLL(head);
        } else if (temp.nextNode == null) {
            return deleteTailOfDLL(head);
        } else {
            DllNode prev = temp.prevNode;
            DllNode next = temp.nextNode;

            prev.nextNode = next;
            next.prevNode = prev;

            temp.prevNode = null;
            temp.nextNode = null;
            return head;
        }
    }

    private static DllNode deleteTailOfDLL(DllNode head) {
        if(head == null || head.nextNode == null) {
            return null;
        }
        DllNode temp = head;
        while (temp.nextNode != null) {
            temp = temp.nextNode;
        }
        temp = temp.prevNode;
        temp.nextNode.prevNode = null;
        temp.nextNode = null;
        return head;
    }

    private static DllNode deleteHeadOfDLL(DllNode head) {

        if(head == null || head.nextNode == null) {
            return null;
        }
        DllNode temp = head.nextNode;
        head.nextNode = null;
        head = temp;
        return head;
    }
}
