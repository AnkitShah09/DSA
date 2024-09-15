package com.demo.dao_authentication_provider;

import java.util.LinkedHashMap;
import java.util.Map;

/*
    Type: Variable Size Sliding Window
    Problem Link: https://leetcode.com/problems/minimum-window-substring/description/
    Solution Link: https://youtu.be/iwv1llyN6mo?si=1gzsInl6pbUsPidH
*/
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String str = "TOTMTAPTAT"; // TOTMTAPTAT, ADOBECODEBANC, a, a
        String t = "TAT"; // TAT, ABC, a, aa

        Map<Character, Integer> chars = new LinkedHashMap<>();
        for(int i=0; i<t.length(); i++) {
            chars.put(t.charAt(i), chars.getOrDefault(t.charAt(i), 0) + 1);
        }

        int size=str.length(), i=0, j=0, charCounts=chars.size();
        char tempChar;
        String output = "";

        while (j<size) {
            tempChar = str.charAt(j);

            if(chars.containsKey(tempChar)) {
                int tempCharCount = chars.get(tempChar)-1;
                chars.put(tempChar, tempCharCount);

                if(tempCharCount == 0) {
                    charCounts--;
                    while (charCounts == 0) {
                        String subString = str.substring(i, j+1);
                        output = output.isEmpty() ? subString :
                                subString.length() < output.length() ? subString : output;
                        System.out.printf("i: %d, j: %d, output: %s \n", i, j, subString);
                        tempChar = str.charAt(i);
                        if(chars.containsKey(tempChar)) {
                            tempCharCount = chars.get(tempChar)+1;
                            chars.put(tempChar, tempCharCount);
                            if(tempCharCount == 1) {
                                charCounts++;
                            }
                        }
                        i++;
                        if(charCounts > 0) {
                            break;
                        }
                    }
                }
            }
            j++;
        }

        System.out.printf("Minimum window sub-string is: %s", output);
    }
}
