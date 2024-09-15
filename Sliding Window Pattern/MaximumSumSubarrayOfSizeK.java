package com.demo.dao_authentication_provider;

public class MaximumSumSubarrayOfSizeK {

/*
    Type: Fixed Size Sliding Window
    Problem Link: https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
    Solution Link: https://youtu.be/KtpqeN0Goro?si=P4CM31zSLXv2Buhy
*/
    public static void main(String[] args) {

        int[] arr = {2, 5, 1, 8, 2, 9, 1};
//        int[] arr = {11, 10, 9, 15, 6, 3, 11, 11, 11, 15};
//        int[] arr = {100, 200, 300, 400};

        int size = arr.length;
        int k = 2;
        int tempSum=0, maxSum=0;
        int i=0, j=0;

        while (j < size) {
            tempSum = tempSum + arr[j];
            if((j-i+1) == k) {
                maxSum = Math.max(tempSum, maxSum);
                tempSum = tempSum - arr[i];
                i++;
            }
            j++;
        }

        System.out.println("Max sum: " + maxSum);
    }
}
