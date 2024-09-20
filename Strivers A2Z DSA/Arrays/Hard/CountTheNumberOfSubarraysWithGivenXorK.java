import java.util.LinkedHashMap;
import java.util.Map;

/*
    Problem Link: https://www.interviewbit.com/problems/subarray-with-given-xor/
    Solution Link: https://youtu.be/eZr-6p0B7ME
*/
public class CountTheNumberOfSubarraysWithGivenXorK {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9}; // {4, 2, 2, 6, 4}, {5, 6, 7, 8, 9}
        int size = arr.length;
        int k = 6, count=0, tempXOR=0;

//      BRUTE-FORCE APPROACH
//        for(int i=0; i<size; i++) {
//            tempXOR = 0;
//            for(int j=i; j<size; j++) {
//                tempXOR = tempXOR ^ arr[j];
//                if(tempXOR == k) {
//                    count++;
//                }
//            }
//        }

//      OPTIMAL APPROACH
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(0, 1);
        for(int i=0; i<size; i++) {
            tempXOR = tempXOR ^ arr[i];
            int remXOR = tempXOR ^ k;

            if(map.containsKey(remXOR)) {
                count = count + map.get(remXOR);
            }

            if(map.containsKey(tempXOR)) {
                map.put(tempXOR, map.get(tempXOR)+1);
            } else {
                map.put(tempXOR, 1);
            }
        }

        System.out.printf("Total sub-arrays are: %d", count);
    }
}
