package BinarySearch.BSOn1DArrays;

/*
    Coding platform Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    Striver's link: https://takeuforward.org/data-structure/last-occurrence-in-a-sorted-array/
    Solution Link: https://youtu.be/hjR1IYVx9lY
*/
public class LastOccurrenceInASortedArray {

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10}; // {3, 4, 7, 13, 13, 13, 20, 20, 40}, {5,7,7,8,8,10}
        int target = 8; // 13, 8
        int size = arr.length;
        int low=0, high=size-1, mid;
        int ans = -1;

        while (low <= high) {
            mid = (low+high)/2;

            if (arr[mid] > target) {
                high = mid-1;
            } else if (arr[mid] < target) {
                low = mid+1;
            } else {
                ans = mid;
                low = mid+1;
            }
        }

        System.out.printf("Last occurrence is: %d", ans);

    }


}
