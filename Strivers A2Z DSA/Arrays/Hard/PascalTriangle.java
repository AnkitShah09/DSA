package Arrays.Hard;

/*
    Problem Link: https://leetcode.com/problems/pascals-triangle/description/
    Solution Link: https://youtu.be/bR7mQgwQ_o8
*/
public class PascalTriangle {

    public static void main(String[] args) {
        int n=4;
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }

        printMatrix(arr);
    }

    private static void printMatrix(int[][] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }
}
