package search;

public class H_Index_II_275 {
    /*
     * Solution: Binary Search
     * Time Complexity: O(logN)
     * Space Complexity: O(1)
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(n == 0) return 0;                         // case: []
        if(n == 1) return citations[0] > 0 ? 1 : 0;  // case: [0]
        int left = 0, right = n;
        while(left < right){
            int mid = (left + right) / 2;
            if(citations[mid] > (n - mid - 1)) right = mid;
            else left = mid + 1;
        }
        return n - left; // n - left - 1 + 1
    }
}
