package Arrays.Easy;

/*
    Problem Link: https://takeuforward.org/data-structure/find-the-largest-element-in-an-array/
    Solution Link: https://youtu.be/37E9ckMDdTk
*/
public class FindTheLargestElementInAnArray {

    public static void main(String[] args) {
//        int[] arr = {2,5,1,3,0};
        int[] arr = {-5, -1, -2, -10};
        int size = arr.length;

        int max = Integer.MIN_VALUE;
        for(int i=0; i<size; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.printf("Largest element is: %d", max);
    }
}
