package BinarySearch.BSOn1DArrays;

/*
    Coding platform Link: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
    Striver's link: https://takeuforward.org/data-structure/search-element-in-a-rotated-sorted-array/
    Solution Link: https://youtu.be/5qGrJbHhqFs
*/
public class SearchElementInARotatedSortedArray1 {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3}; // {4,5,6,7,0,1,2,3}
        int target = 0; // 0
        int size = arr.length;
        int low=0, high=size-1;

        int ans = searchElementInSortedArray(arr, target, low, high);
        System.out.printf("Element found at index: %d", ans);

    }

    private static int searchElementInSortedArray(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] == target) {
                return mid;
            }

            if(arr[low] <= arr[mid]) {
                if(arr[low] <= target && target <= arr[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if(arr[mid] <= target && target <= arr[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }


}
