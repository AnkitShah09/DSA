/*
    Coding platform Link: https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1
    Striver's link: https://takeuforward.org/data-structure/reverse-a-doubly-linked-list/
    Solution Link: https://youtu.be/u3WUW2qe6ww
*/
public class ReverseADoublyLinkedList {

    public static void main(String[] args) {

        DllNode head = null;
        int[] arr = {12, 8, 5, 7};

        head = DllNodeUtils.convertArrayToLinkedList(arr, head);
        DllNodeUtils.printLinkedList(head);

        head = reverseDLL(head);
        DllNodeUtils.printLinkedList(head);
    }

    private static DllNode reverseDLL(DllNode head) {
        if(head == null || head.nextNode == null) {
            return head;
        }

        DllNode temp = head;
        while (temp != null) {

            DllNode prev = temp.prevNode;
            temp.prevNode = temp.nextNode;
            temp.nextNode = prev;

            head = temp;
            temp = temp.prevNode;
        }

        return head;
    }
}
