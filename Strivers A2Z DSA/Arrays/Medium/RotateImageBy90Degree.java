package Arrays.Medium;

/*
    Problem Link: https://leetcode.com/problems/rotate-image/
    Solution Link: https://youtu.be/Z0R2u6gd3GU
*/
public class RotateImageBy90Degree {

    public static void main(String[] args) {

        int[][] arr = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}; // {{1,2,3},{4,5,6},{7,8,9}}, {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}
        int size = arr.length;

        int rowCount = arr.length;
        int colCount = arr[0].length;
        int[][] ans = new int[rowCount][colCount];

//      BRUTE-FORCE APPROACH
//        for(int i=0; i<rowCount; i++) {
//            for (int j = 0; j < colCount; j++) {
//                ans[j][colCount-1-i] = arr[i][j];
//            }
//        }

//      OPTIMAL APPROACH
        // 1. Transpose the matrix
        for(int i=0; i<rowCount; i++) {
            for (int j = i; j < colCount; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // 2. reverse the rows
        for(int i=0; i<rowCount; i++) {
            for (int j = 0; j < colCount/2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][colCount-1-j];
                arr[i][colCount-j-1] = temp;
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
