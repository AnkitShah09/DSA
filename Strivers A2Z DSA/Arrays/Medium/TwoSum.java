import java.util.LinkedHashMap;
import java.util.Map;

/*
    Problem Link: https://leetcode.com/problems/two-sum/description/
    Solution Link: https://youtu.be/UXDSeD9mN-k
*/
public class TwoSum {

    public static void main(String[] args) {

        int[] arr = {2,6,5,8,11}; // {2,7,11,15}, {2,6,5,8,11}, {2,6,5,8,11}
        int target = 15; // 9, 14, 15

        int size = arr.length, index1=-1, index2=-1;
        boolean isTargetAvailable = false;

//      BRUTE-FORCE APPROACH
//        for(int i=0; i<size-1; i++) {
//            for(int j=i; j<size; j++) {
//                if((arr[i]+arr[j]) == target) {
//                    index1 = i;
//                    index2 = j;
//                    isTargetAvailable = true;
//                    break;
//                }
//            }
//            if(isTargetAvailable) {
//                break;
//            }
//        }

//      OPTIMAL APPROACH
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<size; i++) {
            map.put(arr[i], i);
            if(map.containsKey(target-arr[i])) {
                index1 = map.get(target-arr[i]);
                index2 = i;
                break;
            }
        }

        System.out.printf("Index1: %d, Index2: %d", index1, index2);
    }
}
