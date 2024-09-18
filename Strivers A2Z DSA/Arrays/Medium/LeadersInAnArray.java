import java.util.ArrayList;
import java.util.List;

/*
    Problem Link: https://www.geeksforgeeks.org/leaders-in-an-array/
    Solution Link: https://youtu.be/cHrH9CQ8pmY
*/
public class LeadersInAnArray {

    public static void main(String[] args) {

        int[] arr = {10, 22, 12, 3, 0, 6}; // {4, 7, 1, 0}, {10, 22, 12, 3, 0, 6}
        int size = arr.length;
        int max = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();

        for(int i=size-1; i>=0; i--) {
            if(arr[i] > max) {
                max = arr[i];
                ans.add(arr[i]);
            }
        }
        for(int i=ans.size()-1; i>=0; i--) {
            System.out.printf("%d ", ans.get(i));
        }
    }
}
