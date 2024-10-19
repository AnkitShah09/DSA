/*
    Coding platform Link: https://leetcode.com/problems/find-peak-element/description/
    Striver's link: https://takeuforward.org/data-structure/peak-element-in-array/
    Solution Link: https://youtu.be/cXxmbemS6XM
*/
public class PeakElementInArray {

    public static void main(String[] args) {
        int[] arr = {1}; // {1,2,3,4,5,6,7,8,5,1}, {1,2,1,3,5,6,4}, {1,2,3,4,5}, {5,4,3,2,1}, {1}

        int ans = findPeakElement(arr);
        System.out.printf("Peak element index: %d", ans);
    }

    private static int findPeakElement(int[] arr) {
        int size = arr.length;

        if(size == 1) {
            return 0;
        } else if (arr[0] > arr[1]) {
            return 0;
        } else if (arr[size-1] > arr[size-2]) {
            return size-1;
        }

        int mid;
        int ans = -1;
        int low=1, high=size-2;

        while (low <= high) {
            mid = (low+high)/2;
            if((arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1])) {
                ans = mid;
                break;
            }

            if(arr[mid] > arr[mid-1]) {
                // peak element on the right side
                low = mid+1;
            } else {
                // peak element on the left side
                high = mid-1;
            }
        }
        return ans;
    }


}
