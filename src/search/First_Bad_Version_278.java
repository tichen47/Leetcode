package search;

public class First_Bad_Version_278 {
    /*
     * Solution: Binary Search
     * Time Complexity: O(logN)
     * Space Complexity: O(1)
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    
    // Given Function
    public boolean isBadVersion(int num) {
        return true;
    }
}
