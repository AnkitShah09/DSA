import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Problem Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
    Solution Link: https://youtu.be/eMSfBgbiEjk
*/
public class RearrangeArrayElementsBySign {

    public static void main(String[] args) {

        int[] arr = {3,1,-2,-5,2,-4}; // {1,2,-4,-5}, {1,2,-3,-1,-2,3}, {3,1,-2,-5,2,-4}, {-1,1}
        int size = arr.length;
        int[] ans = new int[size];

//      ------------------------------------ VARIETY - 1 ------------------------------------
//      BRUTE-FORCE APPROACH
//        List<Integer> positiveNums = new ArrayList<>();
//        List<Integer> negativeNums = new ArrayList<>();
//        for(int i=0; i<size; i++) {
//            if(arr[i] > 0) {
//                positiveNums.add(arr[i]);
//            } else {
//                negativeNums.add(arr[i]);
//            }
//        }
//        int posIndex=0, negIndex=0;
//        for(int i=0; i<size; i++) {
//            if(i%2==0) {
//                ans[i] = positiveNums.get(posIndex++);
//            } else {
//                ans[i] = negativeNums.get(negIndex++);
//            }
//        }

//      OPTIMAL APPROACH
        int posIndex=0, negIndex=1;
        for(int i=0; i<size; i++) {
            if(arr[i] > 0) {
                ans[posIndex] = arr[i];
                posIndex+=2;
            } else {
                ans[negIndex] = arr[i];
                negIndex+=2;
            }
        }

        Arrays.stream(ans).forEach(num -> System.out.printf("%d ", num));
    }
}
