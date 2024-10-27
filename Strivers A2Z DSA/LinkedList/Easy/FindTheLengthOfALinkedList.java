/*
    Coding platform Link: https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/0
    Striver's link: https://takeuforward.org/linked-list/find-the-length-of-a-linked-list
    Solution Link: https://youtu.be/Nq7ok-OyEpg
*/
public class FindTheLengthOfALinkedList {

    public static void main(String[] args) {

        Node head = null;

        int[] arr = {12, 8, 5, 7};
        head = NodeUtils.convertArrayToLinkedList(arr, head);
        NodeUtils.printLinkedList(head);

        int length = findLinkedListLength(head);
        System.out.printf("Length is: %d", length);
    }

    private static int findLinkedListLength(Node head) {
        int count = 0;

        Node temp = head;
        while (temp!=null) {
            count++;
            temp = temp.nextNode;
        }

        return count;
    }
}
