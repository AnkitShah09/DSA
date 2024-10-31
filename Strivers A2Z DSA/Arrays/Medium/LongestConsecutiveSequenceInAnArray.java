package Arrays.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Problem Link: https://leetcode.com/problems/longest-consecutive-sequence/description/
    Solution Link: https://youtu.be/oO5uLE7EUlM
*/
public class LongestConsecutiveSequenceInAnArray {

    public static void main(String[] args) {

        int[] arr = {0,3,7,2,5,8,4,6,0,1}; // {100, 200, 1, 3, 2, 4}, {3, 8, 5, 7, 6}, {0,3,7,2,5,8,4,6,0,1}
        int size = arr.length;
        int max=0;

//      BRUTE-FORCE APPROACH
//        for(int i=0; i<size; i++) {
//            int counter = 1;
//            int nextEle = arr[i] + 1;
//
//            for(int j=0; j<size; j++) {
//                for(int k=0; k<size; k++) {
//                    if(arr[k] == nextEle) {
//                        counter++;
//                        nextEle = nextEle + 1;
//                        break;
//                    }
//                }
//
//                if(counter == 1) {
//                    break;
//                } else {
//                    max = Math.max(counter, max);
//                }
//            }
//        }

//      BETTER APPROACH
//        Arrays.sort(arr);
//        int counter = 1;
//        for(int i=1; i<size; i++) {
//            if(arr[i] == (arr[i-1]+1)) {
//                counter++;
//                max=Math.max(counter, max);
//            } else {
//                counter = 1;
//            }
//        }

//      OPTIMAL SOLUTION
        Set<Integer> elements = new HashSet<>(Arrays.stream(arr).boxed().toList());
        int counter;
        for(int i=0; i<size; i++) {
            counter = 1;
            if(!elements.contains(arr[i]-1)) {
                int j=1;
                while (elements.contains(arr[i]+j)) {
                    counter++;
                    j++;
                }
                max = Math.max(max, counter);
            }
        }

        System.out.printf("Longest consecutive sequence is: %d", max);
    }
}
