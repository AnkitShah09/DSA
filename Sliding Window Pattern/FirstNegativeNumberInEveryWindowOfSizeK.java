package com.demo.dao_authentication_provider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeNumberInEveryWindowOfSizeK {

/*
    Type: Fixed Size Sliding Window
    Problem Link: https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
    Solution Link: https://youtu.be/uUXXEgK2Jh8?si=LqcqxyRjOtPI0kUs
*/
    public static void main(String[] args) {

//        int[] arr = {-8, 2, 3, -6, 10};
//        int[] arr = {-10, 20, 6, 1, -5, 15, -6, 5, 2};
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 2;

        int size = arr.length;
        List<Integer> ans = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        int i=0, j=0;
        Integer front;
        while (j<size) {
            if(arr[j] < 0) {
                queue.add(arr[j]);
            }

            if((j-i+1) < k) {
                j++;
            } else if ((j-i+1) == k) {
                if(queue.isEmpty()) {
                    ans.add(0);
                } else {
                    front = queue.peek();
                    ans.add(front);

                    if(arr[i] == front) {
                        queue.remove();
                    }
                }
                i++;
                j++;
            }
        }

        System.out.println(ans);

    }
}
