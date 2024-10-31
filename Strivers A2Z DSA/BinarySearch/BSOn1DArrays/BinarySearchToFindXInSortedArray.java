package BinarySearch.BSOn1DArrays;

/*
    Problem Link: https://takeuforward.org/data-structure/binary-search-explained/
    Solution Link: https://youtu.be/MHf6awe89xw
*/

public class BinarySearchToFindXInSortedArray {

    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;

        int index;
//        index = iterativeApproach(arr, target);
        index = recursiveApproach(arr, target);

        if(index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.printf("Element found at index: %d", index);
        }
    }

    private static int recursiveApproach(int[] arr, int target) {
        return recursive(arr, 0, arr.length-1, target);
    }

    private static int recursive(int[] arr, int low, int high, int target) {

        if(low > high) {
            return -1;
        }
        int mid = (low+high)/2;
        if(target == arr[mid]) {
            return mid;
        } else if (target > arr[mid] ) {
            return recursive(arr, mid+1, high, target);
        } else {
            return recursive(arr, low, mid-1, target);
        }
    }

    private static int iterativeApproach(int[] arr, int target) {
        int low=0, high=arr.length-1, mid;
        while(low <= high) {
            mid = (low+high)/2;
            if(target == arr[mid]) {
                return mid;
            } else if (target > arr[mid] ) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

}
