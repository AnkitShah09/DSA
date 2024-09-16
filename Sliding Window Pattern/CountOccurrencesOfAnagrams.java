import java.util.LinkedHashMap;
import java.util.Map;

/*
    Type: Fixed Size Sliding Window
    Problem Link: https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
    Solution Link: https://youtu.be/MW4lJ8Y0xXk?si=0tLfoHSjuqFS6B_a
*/
public class CountOccurrencesOfAnagrams {

    public static void main(String[] args) {

        String str = "aabcbacbaaccbbca"; // forxxorfxdofr, aabaabaa, aabcbacbaaccbbca
        String pat = "abc"; // for, aaba, abc
        int k = pat.length();

        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<pat.length(); i++) {
            map.put(pat.charAt(i), map.getOrDefault(pat.charAt(i), 0) + 1);
        }
        System.out.println(map);

        int ans=0, i=0, j=0, count=map.size();
        while (j<str.length()) {
            char curChar = str.charAt(j);
            if(map.containsKey(curChar)) {
                map.put(curChar, map.get(curChar)-1);
                if(map.get(curChar) == 0) {
                    count--;
                }
            }

            if((j-i+1) < k) {
                j++;
            } else if((j-i+1) == k) {

                if(count == 0) {
                    System.out.printf("i: %d, j: %d \n", i, j);
                    ans++;
                }
                if(map.containsKey(str.charAt(i))) {
                    if(map.get(str.charAt(i)) == 0) {
                        count ++;
                    }
                    map.put(str.charAt(i), map.get(str.charAt(i))+1);
                }
                i++;
                j++;
            }
        }
        System.out.printf("Total Anagrams: %d", ans);
    }
}
