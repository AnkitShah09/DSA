import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Problem Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
    Solution Link: https://youtu.be/eMSfBgbiEjk
*/
public class RearrangeArrayElementsBySign2 {

    public static void main(String[] args) {

        int[] arr = {-1,-2,-3,1,2,3,4,5,-4,-5,-6,-7}; // {1,2,-4,-5,3,4}, {1,2,-3,-1,-2,-3}, {-1,-2,-3,1,2,3,4,5,-4,-5,-6,-7}
        int size = arr.length;
        int[] ans = new int[size];

//      ------------------------------------ VARIETY - 2 ------------------------------------
        List<Integer> positiveNums = new ArrayList<>();
        List<Integer> negativeNums = new ArrayList<>();
        for(int i=0; i<size; i++) {
            if(arr[i] > 0) {
                positiveNums.add(arr[i]);
            } else {
                negativeNums.add(arr[i]);
            }
        }
        int posIndex=0, negIndex=0, i;
        for(i=0; i<size; i++) {
            if(posIndex == positiveNums.size() || negIndex == negativeNums.size()) {
                break;
            }
            if(i%2==0) {
                ans[i] = positiveNums.get(posIndex++);
            } else {
                ans[i] = negativeNums.get(negIndex++);
            }
        }

        if(negIndex == negativeNums.size()) {
            while (posIndex < positiveNums.size()) {
                ans[i++] = positiveNums.get(posIndex++);
            }
        } else if (posIndex == positiveNums.size()) {
            while (negIndex < negativeNums.size()) {
                ans[i++] = negativeNums.get(negIndex++);
            }
        }

        Arrays.stream(ans).forEach(num -> System.out.printf("%d ", num));
    }
}
