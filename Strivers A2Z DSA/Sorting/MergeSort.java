package Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 0, -1, -2}; // {3, 5, -2, 1, 0, 16, 2}, {5, 4, 3, 2, 1, 0, -1, -2}, {1, 2, 3}
        ArraysUtil.printArray(arr);

        mergeSort(arr, 0, arr.length-1);
        ArraysUtil.printArray(arr);
    }

    private static void mergeSort(int[] arr, int low, int high) {

        if(low >= high) {
            return;
        }

        int mid = (low+high)/2;

        // left half
        mergeSort(arr, low, mid);

        // right half
        mergeSort(arr, mid+1, high);

        // merge back the result
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        List<Integer> temp = new ArrayList<>();

        while (left<=mid && right<=high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        int ind = 0;
        for(int i=low; i<=high; i++) {
            arr[i] = temp.get(ind);
            ind++;
        }
    }

}
