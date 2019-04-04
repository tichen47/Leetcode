package binary_search;

public class Search_Insert_Position_35 {
    /*
     * The most important step is to define the bounds of l and r
     */
    
    
    // Solution 1: Find target in [l, r)
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target)
                l = mid + 1;
            else 
                r = mid;
        }
        return l;
    }
    
    
    // Solution 2: Find target in [l, r]
    public int searchInsert2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target)
                l = mid + 1;
            else 
                r = mid - 1;
        }
        return l;
    }
}
