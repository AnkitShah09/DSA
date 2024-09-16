import java.util.Arrays;

/*
    Problem Link: https://takeuforward.org/data-structure/left-rotate-the-array-by-one/
    Solution Link: https://youtu.be/wvcQg43_V8U
*/
public class LeftRotateTheArrayByOne {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int size = arr.length;

        int temp = arr[0];
        for(int i=0; i<size-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[size-1] = temp;
        Arrays.stream(arr).forEach(num -> System.out.printf("%d ", num));
    }
}
