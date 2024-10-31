package BinarySearch.BSOn1DArrays;

/*
    Problem Link: https://takeuforward.org/arrays/search-insert-position/
    Solution Link: https://youtu.be/6zhGS79oQ4k
*/

public class SearchInsertPosition {

    public static void main(String[] args) {
        // Smallest index such as arr[index] > num
        int[] arr = {1,2,4,7}; // {1,2,4,7}, {3,5,8,15,19}
        int x = 6;
        int size = arr.length;

        int low=0, high=size-1, mid;
        int lowerBound = size;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] >= x) {
                high = mid-1;
                lowerBound = mid;
            } else {
                low = mid+1;
            }
        }
        System.out.printf("Higher bound: %d", lowerBound);
    }


}
