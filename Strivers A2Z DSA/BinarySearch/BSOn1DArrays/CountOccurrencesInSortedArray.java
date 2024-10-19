/*
    Problem Link: https://takeuforward.org/data-structure/count-occurrences-in-sorted-array/
    Solution Link: https://youtu.be/hjR1IYVx9lY
*/
public class CountOccurrencesInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 2, 3}; // {2, 2, 3, 3, 3, 3, 4}, {1, 1, 2, 2, 2, 2, 2, 3}
        int target = 2; // 3, 2
        int size = arr.length;
        int count;

        int firstOccurrence = getFirstOccurrence(arr, target);
        if(firstOccurrence==-1) {
            count = -1;
        } else if(firstOccurrence==(size-1)) {
            count = 1;
        } else {
            count = getLastOccurrence(arr, target) - firstOccurrence + 1;
        }
        System.out.printf("Occurrence count is: %d", count);

    }

    public static int getFirstOccurrence(int[] arr, int target) {
        int low=0, high=arr.length-1, mid;
        int ans = -1;
        while (low <= high) {
            mid = (low+high)/2;

            if (arr[mid] > target) {
                high = mid-1;
            } else if (arr[mid] < target) {
                low = mid+1;
            } else {
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }

    public static int getLastOccurrence(int[] arr, int target) {
        int low=0, high=arr.length-1, mid;
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
        return ans;
    }


}
