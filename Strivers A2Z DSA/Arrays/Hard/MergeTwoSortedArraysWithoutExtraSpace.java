package Arrays.Hard;

import java.util.Arrays;

/*
    Problem Link: https://leetcode.com/problems/merge-sorted-array/description/
    Solution Link: https://youtu.be/n7uwj04E0I4
*/
public class MergeTwoSortedArraysWithoutExtraSpace {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {2,5,6};
        int size1=3, size2=3;

//      BRUTE-FORCE APPROACH
//        int[] ans = new int[size1+size2];
//        int i=0,j=0,k=0,index=0;
//
//        for(; k<(size1+size2); k++) {
//            if (i == size1 || j == size2) {
//                break;
//            }
//            if (arr1[i] <= arr2[j]) {
//                ans[k] = arr1[i++];
//            } else {
//                ans[k] = arr2[j++];
//            }
//        }
//
//        if(i==size1) {
//            for(; j<size2; j++,k++) {
//                ans[k] = arr2[j];
//            }
//        } else if(j==size2) {
//            for(; i<size1; i++,k++) {
//                ans[k] = arr1[i];
//            }
//        }
//
//        for(i=0,k=0; i<size1; i++,k++) {
//            arr1[i] = ans[k];
//        }
//        for(j=0; j<size2; j++,k++) {
//            arr2[j] = ans[k];
//        }
//
//        for(int num : arr1) {
//            System.out.print(num + " ");
//        }
//        System.out.println();
//        for(int num : arr2) {
//            System.out.print(num + " ");
//        }
//        System.out.println();
//        for(int num : ans) {
//            System.out.print(num + " ");
//        }

//      OPTIMAL APPROACH
        int i=size1-1, j=0, k=0;
        while (arr1[i]>arr2[j]) {
            int temp = arr2[j];
            arr2[j] = arr1[i];
            arr1[i] = temp;
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();
        for(int num : arr2) {
            System.out.print(num + " ");
        }
    }
}
