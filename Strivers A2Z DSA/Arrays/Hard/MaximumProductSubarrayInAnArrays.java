package Arrays.Hard;

/*
    Problem Link: https://leetcode.com/problems/maximum-product-subarray/description/
    Solution Link: https://youtu.be/hnswaLJvr6g
*/
public class MaximumProductSubarrayInAnArrays {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,0}; // {1,2,3,4,5,0}, {1,2,-3,0,-4,-5}
        int size = arr.length;
        int max=Integer.MIN_VALUE, tempProduct;

//      BRUTE-FORCE APPROACH
//        for(int i=0; i<size-1; i++) {
//            tempProduct = arr[i];
//            for(int j=i+1; j<size; j++) {
//                tempProduct = tempProduct * arr[j];
//                max = Math.max(max, tempProduct);
//            }
//        }

//      OPTIMAL APPROACH
        int prefixProduct=1, suffixProduct=1;
        for(int i=0; i<size; i++) {
            prefixProduct = prefixProduct * arr[i];
            suffixProduct = suffixProduct * arr[i];

            if(arr[i] == 0) {
                prefixProduct = 1;
            }
            if(arr[size-i-1] == 0) {
                suffixProduct = 1;
            }
            max = Math.max(max, Math.max(prefixProduct, suffixProduct));
        }

        System.out.printf("Max product: %d", max);
    }

}
