/*
    Coding platform Link: https://www.geeksforgeeks.org/problems/search-in-linked-list-1664434326/1
    Striver's link: https://takeuforward.org/linked-list/search-an-element-in-a-linked-list
    Solution Link: https://youtu.be/Nq7ok-OyEpg
*/
public class SearchAnElementInALinkedList {

    public static void main(String[] args) {

        Node head = null;
        int[] arr = {12, 8, 5, 7};
        int num = 12;

        head = NodeUtils.convertArrayToLinkedList(arr, head);
        NodeUtils.printLinkedList(head);

        boolean ans = elementInLinkedList(head, num);
        System.out.printf("Element available in the linked list?: %s", ans);
    }

    private static boolean elementInLinkedList(Node head, int num) {
        boolean ans = false;

        Node temp = head;
        while (temp!=null) {
            if(temp.data == num) {
                ans = true;
                break;
            }
            temp = temp.nextNode;
        }

        return ans;
    }
}
