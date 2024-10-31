package recursion.SubsequencesPattern;
/*
    Problem Link: https://takeuforward.org/data-structure/combination-sum-1/
    Solution Link: https://youtu.be/OyZFFqQtu98
*/

import java.util.*;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5}; // {1, 1, 1, 2, 2}, {10, 1, 2, 7, 6, 1, 5}, {2, 5, 2, 1, 2}
        int target = 8; // 4, 8, 5
        Set<List<Integer>> ans = new HashSet<>();

        // answerUsingCombinationSum1(arr, target, ans);

        // better approach
        Arrays.sort(arr);
        combinationSum2(arr, ans, target);

        System.out.println(ans);
    }

    private static void combinationSum2(int[] arr, Set<List<Integer>> ans, int target) {
        int index = 0;
        Stack<Integer> temp = new Stack<>();
        cs2(arr, ans, index, target, temp);
    }

    private static void cs2(int[] arr, Set<List<Integer>> ans, int index, int target, Stack<Integer> temp) {
        if(target == 0) {
            ans.add(temp.stream().toList());
            return;
        }

        for(int i=index; i<arr.length; i++) {
            if(i>index && arr[i]==arr[i-1]) {
                continue;
            }
            int currEle = arr[i];
            if(currEle > target) {
                break;
            }
            temp.push(currEle);
            cs2(arr, ans, i+1, target-currEle, temp);
            temp.pop();
        }

    }

    private static void answerUsingCombinationSum1(int[] arr, int target, Set<List<Integer>> ans) {

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
            cs(arr, ans, index+1, target - currEle, temp);
            temp.pop();
        }

        // not pick the current element
        cs(arr, ans, index + 1, target, temp);

    }
}
