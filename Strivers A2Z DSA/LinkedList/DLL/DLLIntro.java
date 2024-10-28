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

        head = DllNodeUtils.addNodeInLinkedList(9, head);
        DllNodeUtils.printLinkedList(head);
    }
}
