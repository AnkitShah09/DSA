package Arrays.Hard;

import java.util.Arrays;

/*
    Problem Link: https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
    Solution Link: https://youtu.be/2D0D8HE6uak
*/
public class FindTheRepeatingAndMissingNumbers {

    public static void main(String[] args) {
        int[] arr = {3,1,2,5,4,6,7,5}; // {3,1,2,5,3}, {3,1,2,5,4,6,7,5}
        int size = arr.length;

//      BRUTE-FORCE APPROACH
//        int[] ans = new int[2];
//        Arrays.sort(arr);
//        for(int i=1; i<size; i++) {
//            if(arr[i] == arr[i-1]) {
//                ans[0] = arr[i];
//            } else if (arr[i] != (arr[i-1]+1)) {
//                ans[1] = arr[i]-1;
//            }
//        }
//        if(arr[size-1] != size) {
//            ans[1] = arr.length;
//        }


//      OPTIMAL SOLUTION
        long s1=0, s2=0;
        long[] ans = new long[2];

        for(int num: arr) {
            s1 = s1 + num;
            s2 = s2 + (num * num);
        }

        long sn = (size * (size+1))/2;
        long s2n = (size * (size+1) * ((2*size)+1))/6;
        long val1 = s1 - sn;
        long val2 = (s2 - s2n) / val1;
        ans[0] = (val1+val2)/2;
        ans[1] = ans[0] - val1;

        Arrays.stream(ans).forEach(System.out::println);
    }
}
