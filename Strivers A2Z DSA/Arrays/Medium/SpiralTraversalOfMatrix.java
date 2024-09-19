/*
    Problem Link: https://leetcode.com/problems/spiral-matrix/
    Solution Link: https://youtu.be/Z0R2u6gd3GU
*/
public class SpiralTraversalOfMatrix {

    public static void main(String[] args) {

        int[][] arr = {{1}}; // {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}, {{1,2,3},{4,5,6},{7,8,9}}, {1}, {1,2,3,4}
        int size = arr.length;

        int rowCount = arr.length, colCount = arr[0].length;
        int startingRowIndex=0, startingColIndex=0, endingRowIndex=rowCount-1, endingColIndex=colCount-1;
        int tempRowIndex, tempColIndex;

        for(; startingRowIndex<=endingRowIndex; startingRowIndex++, startingColIndex++, endingRowIndex--, endingColIndex--) {

            // To print top row
            for(tempRowIndex=startingRowIndex, tempColIndex=startingColIndex; tempColIndex<=endingColIndex; tempColIndex++) {
                System.out.printf("%4d", arr[tempRowIndex][tempColIndex]);
            }

            tempRowIndex=tempRowIndex+1;
            tempColIndex=tempColIndex-1;

            if(tempRowIndex <= endingRowIndex) {

                // to print right column
                for(; tempRowIndex<=endingRowIndex; tempRowIndex++) {
                    System.out.printf("%4d", arr[tempRowIndex][tempColIndex]);
                }

                // to print bottom row
                for(tempRowIndex=tempRowIndex-1, tempColIndex=tempColIndex-1; tempColIndex>=startingColIndex; tempColIndex--) {
                    System.out.printf("%4d", arr[tempRowIndex][tempColIndex]);
                }

                // to print left side row
                for(tempRowIndex=tempRowIndex-1, tempColIndex=tempColIndex+1; tempRowIndex>startingRowIndex; tempRowIndex--) {
                    System.out.printf("%4d", arr[tempRowIndex][tempColIndex]);
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
