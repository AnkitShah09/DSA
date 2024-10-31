package BinarySearch.BSOn1DArrays;

/*
    Coding platform Link: https://www.geeksforgeeks.org/problems/rotation4723/1
    Striver's link: https://takeuforward.org/arrays/find-out-how-many-times-the-array-has-been-rotated/
    Solution Link: https://youtu.be/jtSiWTPLwd0
*/
public class FindOutHowManyTimesTheArrayHasBeenRotated {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; // {4,5,6,7,0,1,2,3}, {3,4,5,1,2}, {1,2,3,4,5}
        int size = arr.length;
        int low=0, high=size-1;

        int ans = findArrayRotationCount(arr, low, high);
        System.out.printf("Array rotation count: %d", ans);

    }

    private static int findArrayRotationCount(int[] arr, int low, int high) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        while (low <= high) {
            int mid = (low+high)/2;

            if(arr[low] <= arr[high]) {
                if(arr[low] < min) {
                    minIndex = low;
                }
                break;
            }

            if(arr[low] <= arr[mid]) {
                if(arr[low] < min) {
                    min = arr[low];
                    minIndex = low;
                }
                low = mid+1;
            } else {
                if(arr[mid] < min) {
                    min = arr[mid];
                    minIndex = mid;
                }
                high = mid-1;
            }
        }
        return minIndex;
    }


}
