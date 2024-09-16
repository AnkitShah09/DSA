import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
    Type: Fixed Size Sliding Window
    Problem Link: https://www.interviewbit.com/problems/sliding-window-maximum/
    Solution Link: https://youtu.be/xFJXtB5vSmM?si=X_pNbArxkqqAUFnE
*/
public class MaximumOfAllSubarraysOfSizeK {

    public static void main(String[] args) {

//        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k = 3;

        int size = arr.length;
        int max;
        Deque<Integer> deque = new ArrayDeque<>();
        int i=0, j=0, firstElement;
        List<Integer> ans = new ArrayList<>();

        while (j<size) {
            while (!deque.isEmpty() && arr[j]>deque.getLast()) {
                deque.removeLast();
            }
            deque.add(arr[j]);

            if((j-i+1) < k) {
                j++;
            } else if ((j-i+1) == k) {
                firstElement = deque.peekFirst();
                ans.add(firstElement);

                if(arr[i] == firstElement) {
                    deque.removeFirst();
                }
                i++;
                j++;
            }
        }
        System.out.println(ans);
    }
}
