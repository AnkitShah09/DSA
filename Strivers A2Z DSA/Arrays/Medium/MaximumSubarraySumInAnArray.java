/*
    Problem Link: https://leetcode.com/problems/maximum-subarray/description/
    Solution Link: https://youtu.be/AHZpyENo7k4
*/
public class MaximumSubarraySumInAnArray {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4}; // {-2,1,-3,4,-1,2,1,-5,4}, {1}, {-10,-5,-6,-1,-2,-3}
        int size = arr.length;
        int max = Integer.MIN_VALUE;

//      BRUTE-FORCE APPROACH
//        int tempSum = 0;
//        for(int i=0; i<size; i++) {
//            tempSum = 0;
//            for (int j=i; j<size; j++) {
//                tempSum = tempSum + arr[j];
//                max = Math.max(max, tempSum);
//            }
//        }

//      OPTIMAL APPROACH
        int tempSum = 0;
        for(int i=0; i<size; i++) {
            tempSum = tempSum + arr[i];
            max = Math.max(max, tempSum);

            if(tempSum < 0) {
                tempSum = 0;
            }
        }

        System.out.printf("Maximum subarray sum: %d", max);
    }
}
