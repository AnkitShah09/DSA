package BinarySearch.BSOn1DArrays;

/*
    Problem Link: https://takeuforward.org/arrays/implement-lower-bound-bs-2/
    Solution Link: https://youtu.be/6zhGS79oQ4k
*/

public class ImplementLowerBound {

    public static void main(String[] args) {
        // Smallest index such as arr[index] >= num
        int[] arr = {3,5,8,15,19}; // {1,2,2,3}, {3,5,8,15,19}
        int target = 8;
        int size = arr.length;

        int low=0, high=size-1, mid;
        int lowerBound = size;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] >= target) {
                high = mid-1;
                lowerBound = mid;
            } else {
                low = mid+1;
            }
        }
        System.out.printf("Lower bound: %d", lowerBound);
    }


}
