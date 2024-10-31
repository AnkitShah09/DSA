package BinarySearch.BSOn1DArrays;

/*
    Coding platform Link: https://leetcode.com/problems/single-element-in-a-sorted-array/
    Striver's link: https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/
    Solution Link: https://youtu.be/AZOmHuHadxQ
*/
public class SearchSingleElementInASortedArray {

    public static void main(String[] args) {
        int[] arr = {1,2,2}; // {1,1,2,2,3,3,4,5,5,6,6}, {1,1,3,5,5}, {1,2,2,3,3,4,4}, {1,2,2,3,3}, {1}, {1,2,2}

        int ans = findSingleOccurringElementInSortedArray(arr);
        System.out.printf("Single occurring element: %d", ans);
    }

    private static int findSingleOccurringElementInSortedArray(int[] arr) {
        int size = arr.length;

        if(size == 1) {
            return arr[0];
        } else if (arr[0] != arr[1]) {
            return arr[0];
        } else if (arr[size-1] != arr[size-2]) {
            return arr[size-1];
        }

        int mid;
        int ans = -1;
        int low=1, high=size-2;

        while (low <= high) {
            mid = (low+high)/2;
            if((arr[mid-1]!=arr[mid] && arr[mid]!=arr[mid+1])) {
                ans = arr[mid];
                break;
            }

            if(
                ((mid%2==0) && (arr[mid]==arr[mid+1])) ||
                ((mid%2==1) && (arr[mid]==arr[mid-1]))
            ) {
                // eliminate left side
                low = mid+1;
            } else {
                // eliminate right side
                high = mid-1;
            }


        }

        return ans;
    }


}
