import java.util.*;
import java.util.stream.Stream;

/*
    Problem Link: https://leetcode.com/problems/4sum/description/
    Solution Link: https://youtu.be/eD95WRfh81c
*/
public class FourSum {

    public static void main(String[] args) {

        int[] arr = {1,0,-1,0,-2,2}; // {1,0,-1,0,-2,2}, {4,3,3,4,4,2,1,2,1,1}
        int target = 0; // 9

        int size = arr.length, tempSum;
        Set<List<Integer>> ans = new HashSet<>();

//      BRUTE-FORCE APPROACH
//        for(int i=0; i<size-3; i++) {
//            for(int j=i+1; j<size-2; j++) {
//                for(int k=j+1; k<size-1; k++) {
//                    for(int l=k+1; l<size; l++) {
//                        tempSum = arr[i] + arr[j] + arr[k] + arr[l];
//                        if(tempSum == target) {
//                            ans.add(Stream.of(arr[i], arr[j], arr[k], arr[l]).sorted().toList());
//                        }
//                    }
//                }
//            }
//        }

//      BETTER APPROACH
        for(int i=0; i<size; i++) {
            for(int j=i+1; j<size; j++) {
                Set<Integer> set = new HashSet<>();
                for(int k=j+1; k<size; k++) {
                    tempSum = target - (arr[i] + arr[j] + arr[k]);
                    if(set.contains(tempSum)) {
                        ans.add(Stream.of(arr[i], arr[j], arr[k], tempSum).sorted().toList());
                    }
                    set.add(arr[k]);
                }
            }
        }

        ans.forEach(System.out::println);
    }
}
