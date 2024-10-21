/*
    Coding platform Link: https://www.geeksforgeeks.org/problems/square-root/0
    Striver's link: https://takeuforward.org/binary-search/finding-sqrt-of-a-number-using-binary-search/
    Solution Link: https://youtu.be/Bsv3FPUX_BA
*/
public class FindingSqrtOfANumber {

    public static void main(String[] args) {
        int n=25;
        int sqrt = findSqrt(n);
        System.out.printf("Square root is: %d", sqrt);
    }

    private static int findSqrt(int n) {
        int ans = 1;

        // Linear search approach
//        for(int i=1; i<=n; i++) {
//            if((i*i) <= n) {
//                ans = i;
//            } else {
//                break;
//            }
//        }

        // Binary search approach
        int low=1, high=n;
        int mid;
        while (low <= high) {
            mid = (low+high)/2;
            if((mid*mid) <= n) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return ans;
    }


}
