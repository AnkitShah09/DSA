import java.util.LinkedHashMap;
import java.util.Map;

/*
    Type: Variable Size Sliding Window
    Problem Link: Given an array containing N positive integers and an integer K. Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.
    Solution Link: https://youtu.be/cyu_nuW5utA?si=jMf3YdAjJV-Y-F9B
*/
public class LargestSubarrayOfSumK {

    public static void main(String[] args) {

        int[] arr = {4, 1, 1, 1, 2, 3, 5};
//        int[] arr = {2, 3, 4, 6, 9, 4};
//        int[] arr = {4, -1, 2, 1, 1, 3, 0, -5, 10};
        int k = 3;
        int size = arr.length, i=0, j=0, tempSum=0, max=0;

//      0 / Positive numbers only
//        while (j<size) {
//            tempSum = tempSum + arr[j];
//            if(tempSum < k) {
//                j++;
//            } else if (tempSum == k) {
//                System.out.printf("i:%d ,j: %d \n", i, j);
//                max = Math.max(max, (j-i+1));
//                j++;
//            } else {
//                while (tempSum > k) {
//                    tempSum = tempSum - arr[i];
//                    i++;
//                    if(tempSum == k) {
//                        System.out.printf("i:%d ,j: %d \n", i, j);
//                        max = Math.max(max, (j-i+1));
//                    }
//                }
//                j++;
//            }
//        }


//      Prefix Sum Approach
        int count=0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(i=0; i<size; i++) {
            tempSum = tempSum + arr[i];
            if(!map.containsKey(tempSum)) {
                map.put(tempSum, i);
            }

            if(tempSum == k) {
                System.out.printf("Start:0 ,End: %d \n", i);
                max = Math.max(max, i+1);
                count++;
            } else if (map.containsKey(tempSum-k)) {
                System.out.printf("Start:%d ,End: %d \n",(map.get(tempSum-k)+1), i);
                max = Math.max(max, i-map.get(tempSum-k));
                count++;
            }
        }

        System.out.printf("Count: %d\n", count);
        System.out.printf("Max: %d\n", max);
    }
}
