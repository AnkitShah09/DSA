/*
    Coding platform Link: https://www.geeksforgeeks.org/problems/introduction-to-doubly-linked-list/1
    Striver's link: https://takeuforward.org/linked-list/introduction-to-doubly-linked-list
    Solution Link: https://youtu.be/0eKMU10uEDI
*/
public class DLLIntro {

    public static void main(String[] args) {

        DllNode head = null;
        int[] arr = {12, 8, 5, 7};

//        head = DllNodeUtils.convertArrayToLinkedList(arr, head);
//        DllNodeUtils.printLinkedList(head);
//
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
//
//        deleteNode(head.nextNode);
//        DllNodeUtils.printLinkedList(head);
//
//        head = insertBeforeHead(head, 47);
//        DllNodeUtils.printLinkedList(head);
//
//        head = insertBeforeTail(head, 54);
//        DllNodeUtils.printLinkedList(head);
//
//        head = insertBeforeKthElement(head, 2, 54);
//        DllNodeUtils.printLinkedList(head);
//
//        insertBeforeNode(head.nextNode, 34);
//        DllNodeUtils.printLinkedList(head);
    }

    private static void insertBeforeNode(DllNode node, int num) {

        DllNode prev = node.prevNode;

        DllNode newNode = new DllNode(num, node, prev);
        prev.nextNode = newNode;
        node.prevNode = newNode;
    }

    private static DllNode insertBeforeKthElement(DllNode head, int k, int num) {

        if(k == 1) {
            return insertBeforeHead(head, num);
        }

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

        DllNode prev = temp.prevNode;
        DllNode node = new DllNode(num, temp, prev);
        prev.nextNode = node;
        temp.prevNode = node;

        return head;
    }

    private static DllNode insertBeforeTail(DllNode head, int num) {
        DllNode temp = head;

        if(head.nextNode == null) {
            return insertBeforeHead(head, num);
        }

        while (temp.nextNode != null) {
            temp = temp.nextNode;
        }
        DllNode prev = temp.prevNode;
        DllNode node = new DllNode(num, temp, prev);

        prev.nextNode = node;
        temp.prevNode = node;
        return head;
    }

    private static DllNode insertBeforeHead(DllNode head, int num) {
        DllNode node = new DllNode(num, head, null);

        if(head != null) {
            head.prevNode = node;
        }
        head = node;
        return head;
    }

    private static void deleteNode(DllNode node) {
        // Node cannot be head so didn't need to write logic for it.

        DllNode prev = node.prevNode;
        DllNode next = node.nextNode;

        if(next == null) {
            node.prevNode = null;
            prev.nextNode = null;
            return;
        }
        prev.nextNode = next;
        next.prevNode = prev;

        node.prevNode = null;
        node.nextNode = null;
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
