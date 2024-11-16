package Sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 0, -1, -2}; // {3, 5, -2, 1, 0, 16, 2}, {5, 4, 3, 2, 1, 0, -1, -2}
        ArraysUtil.printArray(arr);

        quickSort(arr, 0, arr.length-1);
        ArraysUtil.printArray(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }

        int pIndex = partition(arr, low, high);

        // left half
        quickSort(arr, low, pIndex-1);

        // right half
        quickSort(arr, pIndex+1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            while (arr[j] > pivot && j > low) {
                j--;
            }
            if(i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
