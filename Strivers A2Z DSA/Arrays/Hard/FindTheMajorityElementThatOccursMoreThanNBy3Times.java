package Arrays.Hard;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
    Problem Link: https://leetcode.com/problems/majority-element-ii/description/
    Solution Link: https://youtu.be/vwZj1K0e9U8
*/
public class FindTheMajorityElementThatOccursMoreThanNBy3Times {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,2}; // {1,2,2,3,2}, {11,33,33,11,33,11}, {1,2}
        int size = arr.length;
        int n = (size/3)+1;
        List<Integer> majorityNumbers = new ArrayList<>();

//      BETTER APPROACH
//        Map<Integer, Integer> numbersCount = new LinkedHashMap<>();
//        for(int i=0; i<size; i++) {
//            numbersCount.put(arr[i], numbersCount.getOrDefault(arr[i], 0)+1);
//        }
//        for(Map.Entry<Integer, Integer> m: numbersCount.entrySet()) {
//            if(m.getValue() >= n) {
//                majorityNumbers.add(m.getKey());
//            }
//        }

//      OPTIMAL SOLUTION
        int cnt1=0, cnt2=0, e1=Integer.MIN_VALUE, e2=Integer.MIN_VALUE;
        for(int i=0; i<size; i++) {
            if(cnt1 == 0 && arr[i]!=e2) {
                cnt1++;
                e1 = arr[i];
            } else if(cnt2 == 0 && arr[i]!=e1) {
                cnt2++;
                e2 = arr[i];
            } else if (e1 == arr[i]) {
                cnt1++;
            } else if (e2 == arr[i]) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Manually check if the stored elements in e1 and e2 are the majority elements:
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == e1) {
                cnt1++;
            }
            if (arr[i] == e2) {
                cnt2++;
            }
        }

        if(cnt1 >= n) {
            majorityNumbers.add(e1);
        }
        if(cnt2 >= n) {
            majorityNumbers.add(e2);
        }

        majorityNumbers.forEach(num -> System.out.printf("Number that is more than N/3 is: %d\n", num));
    }
}
