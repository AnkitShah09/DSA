package Arrays.Medium;

// Input: str = aaabbaaaacccccbbbccd, output: {a=4, b=3, c=5, d=1}
// Input: str = abcdefghijkl, output: {a=1, b=1, c=1, d=1, e=1, f=1, g=1, h=1, i=1, j=1, k=1, l=1}
// Input: str = abaabbbccddddcccaaa, output: {a=3, b=3, c=3, d=4}

import java.util.LinkedHashMap;
import java.util.Map;

public class FindMaxContinousFrequenciesOfAllCharactersInString {

    public static void main(String[] args) {
//        String str = "aaabbaaaacccccbbbccd";
//        String str = "abcdefghijkl";
        String str="abaabbbccddddcccaaa";
//        String str = "a";

//      2-Pointer approach
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        int size=str.length(), start=0, end=1;
        char curr=str.charAt(start);
        charCount.put(curr, 1);
        while (end < size) {
            curr = str.charAt(end);
            if(curr != str.charAt(start)) {
                charCount.put(curr, Math.max(1, charCount.getOrDefault(curr, 0)));
                start = end;
            } else {
                charCount.put(curr, Math.max(end-start+1, charCount.get(curr)));
            }
            end++;
        }

        System.out.println(charCount);
    }
}
