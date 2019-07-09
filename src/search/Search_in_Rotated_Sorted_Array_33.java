package search;

public class Search_in_Rotated_Sorted_Array_33 {
    /*
     * Solution: Binary Search (One Time)
     * Time Complexity: O(logN)
     * Space Complexity: O(1)
     */
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            // In first part
            if(nums[mid] >= nums[0]){
                // Target can only in range [mid + 1, right]
                if(target > nums[mid] || target < nums[0])
                    left = mid + 1;
                // Target in [left,mid]
                else 
                    right = mid;
            }
            // In second part
            else{
                // Target can only in range [left, mid]
                if(target <= nums[mid] || target >= nums[0])
                    right = mid;
                // Target in [mid + 1, right]
                else
                    left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
    
    /*
     * Solution: Binary Search (Two Times)
     * Time Complexity: O(logN)
     * Space Complexity: O(1)
     */
    public int search2(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        if(n == 1) return nums[0] == target ? 0 : -1;
        
        int rotIndex = findRotateIndex(nums);

        int left = target <= nums[n-1] ? rotIndex : 0;
        int right = target <= nums[n-1] ? n-1 : rotIndex-1;
        
        while(left < right){
            int mid = (left + right + 1) >>> 1;
            if(nums[mid] <= target) left = mid;
            else right = mid - 1;
        }
        return nums[left] == target ? left : -1;
    }
    
    public int findRotateIndex(int[] nums){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    
    
}
