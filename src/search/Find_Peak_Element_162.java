package search;

public class Find_Peak_Element_162 {
    /*
     * Solution: Recursive Binary Search
     * Time Complexity: O(logN)
     * Space Complexity: O(1)
     */
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length-1);
    }
    
    public int search(int[] nums, int left, int right){
        if(left == right) return left;
        
        int mid = left + (right - left) / 2;
        if(nums[mid] >= nums[mid+1])
            return search(nums, left, mid);
        return search(nums, mid+1, right);
    }
    
    /*
     * Solution: Iterative Binary Search
     * Time Complexity: O(logN)
     * Space Complexity: O(1)
     */
    public int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[mid + 1])
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
