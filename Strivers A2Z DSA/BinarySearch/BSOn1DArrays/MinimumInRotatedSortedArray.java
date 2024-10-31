package BinarySearch.BSOn1DArrays;

/*
    Coding platform Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    Striver's link: https://takeuforward.org/data-structure/minimum-in-rotated-sorted-array/
    Solution Link: https://youtu.be/nhEMDKMB44g
*/
public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3}; // {4,5,6,7,0,1,2,3}, {3, 4, 1, 2}
        int size = arr.length;
        int low=0, high=size-1;

        int ans = findMinElementInSortedArray(arr, low, high);
        System.out.printf("Min element: %d", ans);

    }

    private static int findMinElementInSortedArray(int[] arr, int low, int high) {
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low+high)/2;

            if(arr[low] <= arr[high]) {
                min = Math.min(min, arr[low]);
                break;
            }

            if(arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid+1;
            } else {
                min = Math.min(min, arr[mid]);
                high = mid-1;
            }
        }
        return min;
    }


}
