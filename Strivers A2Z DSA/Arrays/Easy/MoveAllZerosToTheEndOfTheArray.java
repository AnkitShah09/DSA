import java.util.Arrays;

/*
    Problem Link: https://leetcode.com/problems/move-zeroes/description/, https://takeuforward.org/data-structure/move-all-zeros-to-the-end-of-the-array/
    Solution Link: https://youtu.be/wvcQg43_V8U
*/
public class MoveAllZerosToTheEndOfTheArray {

    public static void main(String[] args) {

        int[] arr = {1 ,0 ,2 ,3 ,0 ,4 ,0 ,1};
//        int[] arr = {1, 2, 0, 1, 0, 4, 0};
//        int[] arr = {0, 0, 0};
//        int[] arr = {1, 2, 3};
//        int[] arr = {0, 0, 0, 1, 2, 3};
        int size = arr.length;

        int i, j=-1;
        for(i=0; i<size; i++) {
            if(arr[i] == 0) {
                j = i+1;
                break;
            }
        }

        if(j==-1) {
            System.out.println("No zeroes found in the array");
            return;
        }

        for(; j<size; j++) {
            if(arr[j] != 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

        Arrays.stream(arr).forEach(ele -> System.out.printf("%d ", ele));
    }
}
