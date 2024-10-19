/*
    Coding platform Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
    Striver's link: https://takeuforward.org/arrays/search-element-in-rotated-sorted-array-ii/
    Solution Link: https://youtu.be/w2G2W8l__pc
*/
public class SearchElementInARotatedSortedArray2 {

    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6}; // {7, 8, 1, 2, 3, 3, 3, 4, 5, 6}, {3,1,2,3,3,3,3}
        int target = 8; // 3, 1
        int size = arr.length;
        int low=0, high=size-1;

        boolean ans = searchElementInSortedArray(arr, target, low, high);
        System.out.printf("Element found?: %s", ans);

    }

    private static boolean searchElementInSortedArray(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] == target) {
                return true;
            }

            if(arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low+1;
                high = high-1;
                continue;
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
        return false;
    }


}
