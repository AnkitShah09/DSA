package Arrays.Medium;

import java.util.LinkedHashMap;
import java.util.Map;

/*
    Problem Link: https://leetcode.com/problems/subarray-sum-equals-k/description/
    Solution Link: https://youtu.be/xvNwoz-ufXA
*/
public class CountSubarraySumEqualsK {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 4}; // {3, 1, 2, 4}, {1,2,3}
        int k = 3;
        int size = arr.length, i=0, j=0, tempSum=0, max=0;

//      Prefix Sum Approach
        int count=0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(i=0; i<size; i++) {
            tempSum = tempSum + arr[i];
            if(!map.containsKey(tempSum)) {
                map.put(tempSum, i);
            }

            if(tempSum == k) {
//                System.out.printf("Start:0 ,End: %d \n", i);
                max = Math.max(max, i+1);
                count++;
            } else if (map.containsKey(tempSum-k)) {
//                System.out.printf("Start:%d ,End: %d \n",(map.get(tempSum-k)+1), i);
                max = Math.max(max, i-map.get(tempSum-k));
                count++;
            }
        }

        System.out.printf("Count: %d\n", count);
    }
}
