/*
    Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    Solution Link: https://youtu.be/eMSfBgbiEjk
*/
public class StockBuyAndSell {

    public static void main(String[] args) {

        int[] arr = {7,1,5,3,6,4}; // {7,1,5,3,6,4}, {7,6,4,3,1}, {2,6,5,8,11}
        int size = arr.length;
        int max=0;

//      BRUTE-FORCE APPROACH
//        for(int i=0; i<size-1; i++) {
//            for(int j=i+1; j<size; j++) {
//                max = Math.max(max, arr[j]-arr[i]);
//            }
//        }

//      OPTIMAL APPROACH
        int min=arr[0];
        for(int i=1; i<size; i++) {
            max = Math.max(max, (arr[i]-min));
            min = Math.min(min, arr[i]);
        }

        System.out.printf("Max profit: %d", max);
    }
}
