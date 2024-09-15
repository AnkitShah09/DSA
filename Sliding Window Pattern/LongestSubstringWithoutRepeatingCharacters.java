package com.demo.dao_authentication_provider;

import java.util.HashSet;
import java.util.Set;

/*
    Type: Variable Size Sliding Window
    Problem Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
    Solution Link: https://youtu.be/L6cffskouPQ?si=iQfNojh3Dy7_HuRG
*/
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        String str = "pwwkew"; // abcabcbb, bbbbb, pwwkew

        int i=0, j=0, size=str.length(), max=-1;
        char tempChar;
        Set<Character> chars = new HashSet<>();

        while (j<size) {
            tempChar = str.charAt(j);
            if(!chars.contains(tempChar)) {
                chars.add(tempChar);
            } else {
                while (tempChar != str.charAt(i)) {
                    chars.remove(str.charAt(i));
                    i++;
                }
                i++;
            }
            System.out.printf("i: %d, j: %d, size: %d\t", i, j, (j-i+1));
            System.out.println(chars);
            max = Math.max(max, j-i+1);
            j++;
        }
        System.out.printf("Max: %d", max);
    }
}
