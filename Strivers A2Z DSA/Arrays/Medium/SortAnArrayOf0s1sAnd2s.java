package Arrays.Medium;

import java.util.Arrays;

/*
    Problem Link: https://leetcode.com/problems/sort-colors/description/
    Solution Link: https://youtu.be/tp8JIuCXBaU
*/
public class SortAnArrayOf0s1sAnd2s {

    public static void main(String[] args) {

        int[] arr = {1,1,2,2,0,0,2,2,0,0}; // {2,0,2,1,1,0}, {0}, {1,1,2,2,0,0,2,2,0,0}, {2,1,0}, {2,1,2,1,0,0,0,0,2,2}
        int size = arr.length;

        int low=0, mid=0, high=size-1;
        while (mid <= high){
            if(arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            } else if(arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            } else {
                mid++;
            }
        }

        Arrays.stream(arr).forEach(num -> System.out.printf("%d ", num));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
