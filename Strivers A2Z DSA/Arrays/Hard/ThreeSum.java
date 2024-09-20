import java.util.*;
import java.util.stream.Stream;

/*
    Problem Link: https://leetcode.com/problems/3sum/description/
    Solution Link: https://youtu.be/DhFh8Kw7ymk
*/
public class ThreeSum {

    public static void main(String[] args) {

        int[] arr = {-1,0,1,2,-1,-4}; // {-1,0,1,2,-1,-4}, {-1,0,1,0}
        int target = 0;

        int size = arr.length, tempSum;
        Set<List<Integer>> ans = new HashSet<>();

//      BRUTE-FORCE APPROACH
//        for(int i=0; i<size-2; i++) {
//            for(int j=i+1; j<size-1; j++) {
//                for(int k=j+1; k<size; k++) {
//                    tempSum = arr[i] + arr[j] + arr[k];
//                    if(tempSum == target) {
//                        List<Integer> integers = Arrays.asList(arr[i], arr[j], arr[k]);
//                        integers.sort(Comparator.naturalOrder());
//                        ans.add(integers);
//                    }
//                }
//            }
//        }

//      BETTER APPROACH
//        for(int i=0; i<size-2; i++) {
//            Set<Integer> set = new HashSet<>();
//            for(int j=i+1; j<size-1; j++) {
//                tempSum = target - (arr[i] + arr[j]);
//                if(set.contains(tempSum)) {
//                    ans.add(Stream.of(arr[i], arr[j], tempSum).sorted().toList());
//                }
//                set.add(arr[j]);
//            }
//        }

//      OPTIMAL SOLUTION
        Arrays.sort(arr);;
        int i, j, k;
        for(i=0; i<size-2; i++) {

            j = i+1;
            k = size-1;
            while (j<k) {
                tempSum = arr[i] + arr[j] + arr[k];
                if(tempSum > target) {
                    k--;
                } else if(tempSum < target) {
                    j++;
                } else {
                    ans.add(Stream.of(arr[i], arr[j], tempSum).sorted().toList());
                    j++;
                    k--;

                    // To skip the duplicates:
                    while (j<k && arr[j]==arr[j-1]) {
                        j++;
                    }
                    while (j<k && arr[k] == arr[k+1]) {
                        k--;
                    }
                }
            }
        }

        ans.forEach(System.out::println);
    }
}
