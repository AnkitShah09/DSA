/*
    Problem Link: https://www.naukri.com/code360/problems/number-of-inversions_6840276
    Solution Link: https://youtu.be/AseUmwVNaoY
*/
public class CountInversionsInAnArray {

    private static int counter = 0;

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1}; // {5,4,3,2,1}, {1,2,3,4,5}, {5,3,2,1,4}
        int size = arr.length;

//      BRUTE-FORCE APPROACH
//        for(int i=0; i<size-1; i++) {
//            for(int j=i+1; j<size; j++) {
//                if(arr[j] < arr[i]) {
//                    counter++;
//                }
//            }
//        }


//      OPTIMAL SOLUTION
        mergeSort(arr, 0, size-1);


        System.out.printf("Total inversions are: %d", counter);
    }

    private static void mergeSort(int[] arr, int start, int end) {

        if(start >= end) {
            return;
        }
        int mid = (start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int left = start, right = mid+1;
        int[] temp = new int[start+end+1];
        int index = left;

        while (left <= mid && right <= end) {
            if(arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                counter = counter + (mid-left+1);
                temp[index++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= end) {
            temp[index++] = arr[right++];
        }

        for(int i=start; i<index; i++) {
            arr[i] = temp[i];
        }
    }

}
