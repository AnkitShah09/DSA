import java.util.Arrays;

/*
    Problem Link: https://takeuforward.org/data-structure/rotate-array-by-k-elements/
    Solution Link: https://youtu.be/wvcQg43_V8U
*/
public class RotateArrayByKElements {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
//        int[] arr = {-10, 4, -3, 5, 3, 6, 134};
        int k = 2;
//        String rotation = "left";
        String rotation = "right";

        k = k % arr.length;
        if("left".equals(rotation)) {
            rotateArrayToLeft(arr, k);
        } else if ("right".equals(rotation)) {
            rotateArrayToRight(arr, k);
        }

        Arrays.stream(arr).forEach(num -> System.out.printf("%d ", num));
    }

    public static void rotateArrayToLeft(int[] arr, int k) {
        int size = arr.length;

//      BRUTE-FORCE APPROACH
//        int[] temp = new int[k];
//        for(int i=0; i<k; i++) {
//            temp[i] = arr[i];
//        }
//
//        for(int i=k; i<size; i++) {
//            arr[i-k] = arr[i];
//        }
//
//        for(int i=size-k; i<size; i++) {
//            arr[i] = temp[i-(size-k)];
//        }

//      OPTIMAL APPROACH
        reverse(arr, 0, k-1);
        reverse(arr, k, size-1);
        reverse(arr, 0, size-1);
    }

    public static void rotateArrayToRight(int[] arr, int k) {
        int size = arr.length;

//      BRUTE-FORCE APPROACH
//        int[] temp = new int[k];
//        for(int i=size-k, j=0; i<size; i++, j++) {
//            temp[j] = arr[i];
//        }
//
//        for(int i=size-k-1, j=size-1; i>=0; i--, j--) {
//            arr[j] = arr[i];
//        }
//
//        for(int i=0; i<k; i++) {
//            arr[i] = temp[i];
//        }

//      OPTIMAL APPROACH
        reverse(arr, 0, size-k-1);
        reverse(arr, size-k, size-1);
        reverse(arr, 0, size-1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
