import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Problem Link: https://leetcode.com/problems/merge-intervals/description/
    Solution Link: https://youtu.be/IexN60k62jo
*/
public class MergeOverlappingSubIntervals {

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}}; // {{1,3},{2,6},{8,10},{15,18}}, {{1,4},{4,5}}
        int size = arr.length;
        List<List> ans = new ArrayList<>();

        // 1. Sort the array first, so we can get all the elements in order.
        Arrays.sort(arr, (a1, a2) -> a1[0]==a2[0] ? a1[1]-a2[1] : a1[0]-a2[0]);

        int start=arr[0][0], end=arr[0][1];
        for(int i=1; i< size; i++) {
            if(arr[i][0] <= end) {
                if(arr[i][1] > end) {
                    end = arr[i][1];
                }
            } else {
                ans.add(List.of(start, end));
                start = arr[i][0];
                end = arr[i][1];
            }
        }

        if(arr[size-1][0]==start || arr[size-1][1]==end) {
            ans.add(List.of(start, end));
        }

        ans.forEach(System.out::println);
    }
}
