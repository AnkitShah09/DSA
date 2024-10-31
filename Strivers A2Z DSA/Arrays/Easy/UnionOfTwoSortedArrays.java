package Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

/*
    Problem Link: https://takeuforward.org/data-structure/union-of-two-sorted-arrays/
    Solution Link: https://youtu.be/wvcQg43_V8U
*/
public class UnionOfTwoSortedArrays {

    public static void main(String[] args) {

//        int arr1[] = {1, 2, 3, 4, 5};
//        int arr2[] = {2, 3, 4, 4, 5};
        int arr1[] = {1,2,3,4,5,6,7,8,9,10};
        int arr2[] = {2,3,4,4,5,11,12};
        int n = arr1.length;
        int m = arr2.length;
        List<Integer> resultArr = new ArrayList<>();

        int i=0, j=0;
        while (i<n && j<m) {
            if(arr1[i] < arr2[j]) {
                if(!resultArr.contains(arr1[i])) {
                    resultArr.add(arr1[i]);
                }
                i++;
            } else if(arr1[i] > arr2[j]) {
                if(!resultArr.contains(arr2[j])) {
                    resultArr.add(arr1[j]);
                }
                j++;
            } else {
                resultArr.add(arr1[i]);
                i++;
                j++;
            }
        }

        if(i==n) {
            while (j<m) {
                resultArr.add(arr2[j++]);
            }
        }

        if(j==m) {
            while (i<n) {
                resultArr.add(arr1[i++]);
            }
        }

        resultArr.forEach(num -> System.out.printf("%d ", num));
    }
}
