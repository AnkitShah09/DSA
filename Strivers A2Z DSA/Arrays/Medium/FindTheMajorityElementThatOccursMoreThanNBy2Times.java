/*
    Problem Link: https://leetcode.com/problems/majority-element/description/
    Solution Link: https://youtu.be/nP_ns3uSh80
*/
public class FindTheMajorityElementThatOccursMoreThanNBy2Times {

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2}; // {2,2,1,1,1,2,2,1,1}, {2,2,1,1,1,2,2}, {3,2,3}
        int size = arr.length;

        int n = arr[0];
        int count = 1;
        for(int i=1; i<size; i++) {
            if(arr[i] == n) {
                count++;
            } else if (count == 0) {
                n = arr[i];
                count++;
            } else {
                count--;
            }
        }

        System.out.printf("Number that is more than N/2 is: %d", n);
    }
}
