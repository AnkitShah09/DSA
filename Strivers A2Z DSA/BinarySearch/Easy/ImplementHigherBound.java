/*
    Problem Link: https://takeuforward.org/arrays/implement-upper-bound/
    Solution Link: https://youtu.be/6zhGS79oQ4k
*/

public class ImplementHigherBound {

    public static void main(String[] args) {
        // Smallest index such as arr[index] > num
        int[] arr = {3,5,8,15,19}; // {1,2,2,3}, {3,5,8,15,19}
        int target = 3;
        int size = arr.length;

        int low=0, high=size-1, mid;
        int higherBound = size;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid-1;
                higherBound = mid;
            } else {
                low = mid+1;
            }
        }
        System.out.printf("Higher bound: %d", higherBound);
    }


}
