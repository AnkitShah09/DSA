package com.demo.dao_authentication_provider;

import java.util.LinkedHashMap;
import java.util.Map;

/*
    Type: Variable Size Sliding Window
    Problem Link: https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
    Solution Link: https://youtu.be/Lav6St0W_pQ?si=Aj-2vp6GfBeaD1wC
*/
public class LongestSubstringWithKUniqueCharacters {

    public static void main(String[] args) {

        String str = "aabacbebebe"; // aaaa, abcabcbb, pwwkew
        int k = 3;

        int ans=-1, i=0, j=0, size=str.length();
        char tempChar;
        Map<Character, Integer> charCounts = new LinkedHashMap<>();

        while (j<size) {
            tempChar = str.charAt(j);
            charCounts.put(tempChar, charCounts.getOrDefault(tempChar, 0)+1);

            if(charCounts.size() < k) {
                j++;
            } else if (charCounts.size() == k) {
                System.out.printf("i: %d, j: %d, size: %d \n", i, j, (j-i+1));
//                System.out.println(charCounts);
                ans = Math.max(ans, j-i+1);
                j++;
            } else {
                while (charCounts.size() > k) {
                    tempChar = str.charAt(i);
                    int count = charCounts.get(tempChar) - 1;
                    charCounts.put(tempChar, count);
                    if(count == 0) {
                        charCounts.remove(tempChar);
                    }
                    i++;
                }
                System.out.printf("i: %d, j: %d, size: %d \n", i, j, (j-i+1));
//                System.out.println(charCounts);
                ans = Math.max(ans, j-i+1);
                j++;
            }
        }
        System.out.printf("Longest substring length: %d", ans);
    }
}
