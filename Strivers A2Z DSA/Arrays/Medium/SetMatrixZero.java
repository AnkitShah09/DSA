/*
    Problem Link: https://leetcode.com/problems/set-matrix-zeroes/description/
    Solution Link: https://youtu.be/N0MgLvceX7M
*/
public class SetMatrixZero {

    public static void main(String[] args) {

        int[][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}}; // {{1,1,1},{1,0,1},{1,1,1}}, {{0,1,2,0},{3,4,5,2},{1,3,1,5}}
        int size = arr.length;

        int rowCount = arr.length;
        int colCount = arr[0].length;

//      BRUTE-FORCE APPROACH
//        for(int i=0; i<rowCount; i++) {
//            for(int j=0; j<colCount; j++) {
//                if(arr[i][j] == 0) {
//                    arr[i][j] = -1;
//                    markRowMinusOne(arr, i, colCount);
//                    markColMinusOne(arr, j, rowCount);
//                }
//            }
//        }
//        convertMinusOneToZero(arr, rowCount, colCount);


//      BETTER APPROACH
//        int[] colArr = new int[colCount];
//        int[] rowArr = new int[rowCount];
//        for(int i=0; i<rowCount; i++) {
//            for(int j=0; j<colCount; j++) {
//                if(arr[i][j] == 0) {
//                    rowArr[i] = 1;
//                    colArr[j] = 1;
//                }
//            }
//        }
//        for(int i=0; i<rowCount; i++) {
//            for (int j = 0; j < colCount; j++) {
//                if(rowArr[i]==1 || colArr[j]==1) {
//                    arr[i][j] = 0;
//                }
//            }
//        }

//      OPTIMAL APPROACH
        int[] colArr = new int[colCount];
        int[] rowArr = new int[rowCount];
        int col0=1;
        for(int i=0; i<rowCount; i++) {
            for(int j=0; j<colCount; j++) {
                if (arr[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        col0 = 0;
                    } else if (j == 0) {
                        col0 = 0;
                        arr[i][0] = 0;
                    } else {
                        arr[i][0] = 0;
                        arr[0][j] = 0;
                    }
                }
            }
        }

        for(int i=1; i<rowCount; i++) {
            for (int j=1; j<colCount; j++) {
                if (arr[0][j] == 0 || arr[i][0] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        if(arr[0][0] == 0) {
            for(int j=0; j<colCount; j++) {
                arr[0][j] = 0;
            }
        }
        if(col0 == 0) {
            for(int i=0; i<rowCount; i++) {
                arr[i][0] = 0;
            }
        }

        printMatrix(arr);
    }

    private static void markColMinusOne(int[][] arr, int j, int rowCount) {
        for(int i=0; i<rowCount; i++) {
            if(arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    private static void markRowMinusOne(int[][] arr, int i, int colCount) {
        for(int j=0; j<colCount; j++) {
            if(arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    private static void convertMinusOneToZero(int[][] arr, int rowCount, int colCount) {
        for(int i=0; i<rowCount; i++) {
            for(int j=0; j<colCount; j++) {
                if(arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
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
