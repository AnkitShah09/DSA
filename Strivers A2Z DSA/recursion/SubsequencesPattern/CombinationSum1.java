/*
    Problem Link: https://takeuforward.org/data-structure/combination-sum-1/
    Solution Link: https://youtu.be/OyZFFqQtu98
*/

import java.util.*;

public class CombinationSum1 {

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5}; // {2,3,6,7}. {10, 1, 2, 7, 6, 1, 5}, {2, 3, 5}
        int target = 8; // 7, 8, 8
        Set<List<Integer>> ans = new HashSet<>();

        combinationSum(arr, target, ans);
        System.out.println(ans);
    }

    private static void combinationSum(int[] arr, int target, Set<List<Integer>> ans) {

        int index = 0;
        Stack<Integer> temp = new Stack<>();
        cs(arr, ans, index, target, temp);
    }

    private static void cs(int[] arr, Set<List<Integer>> ans, int index, int target, Stack<Integer> temp) {
        if(index == arr.length) {
            if(target == 0) {
                ans.add(temp.stream().sorted(Comparator.naturalOrder()).toList());
            }
            return;
        }

        int currEle = arr[index];
        if(currEle <= target) {

            // pick the current element
            temp.push(currEle);
            cs(arr, ans, index, target - currEle, temp);
            temp.pop();
        }

        // not pick the current element
        cs(arr, ans, index + 1, target, temp);

    }
}
