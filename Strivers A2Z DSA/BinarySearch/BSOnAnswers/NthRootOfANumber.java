package BinarySearch.BSOnAnswers;

/*
    Coding platform Link: https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
    Striver's link: https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/
    Solution Link: https://youtu.be/rjEJeYCasHs
*/
public class NthRootOfANumber {

    public static void main(String[] args) {
        int num=64;
        int nRoot=3;
        int sqrt = findNthRoot(num, nRoot);
        System.out.printf("Square root is: %d", sqrt);
    }

    private static int findNthRoot(int num, int nRoot) {
        int ans = -1;

        // Binary search approach
        int low=1, high=num;
        int mid;
        while (low <= high) {
            mid = (low+high)/2;

            int nPower = findNPower(mid, num, nRoot);
            if(nPower == num) {
                ans = mid;
                break;
            } if(nPower == 1) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;
    }

    private static int findNPower(int mid, int num, int nRoot) {
        int temp = 1;
        for(int j=1; j<=nRoot; j++) {
            temp = temp * mid;
            if(temp > num) {
                return 1;
            }
        }
        return temp;
    }


}
