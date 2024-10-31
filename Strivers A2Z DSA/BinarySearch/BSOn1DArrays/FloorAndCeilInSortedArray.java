package BinarySearch.BSOn1DArrays;

/*
    Problem Link: https://takeuforward.org/arrays/floor-and-ceil-in-sorted-array/
    Solution Link: https://youtu.be/6zhGS79oQ4k
*/

public class FloorAndCeilInSortedArray {

    public static void main(String[] args) {
        // Smallest index such as arr[index] > num
        int[] arr = {3, 4, 4, 7, 8, 10}; // {3, 4, 4, 7, 8, 10}
        int x = 5;
        int size = arr.length;
        int floor=-1, ceiling=-1;
        int low=0, high=size-1, mid;

        while (low <= high) {
            mid = (low+high)/2;

            int midVal = arr[mid];
            if(midVal == x) {
                floor = ceiling = midVal;
                break;
            } else if(midVal < x) {
                floor = midVal;
                low = mid+1;
            } else {
                ceiling = midVal;
                high = mid-1;
            }
        }

        System.out.printf("Floor value: %d, Ceiling bound: %d", floor, ceiling);
    }


}
