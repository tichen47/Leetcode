package search;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_34 {
    /*
     * Solution: Fake Binary Search
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        boolean find = false;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                find = true;
                left = mid;
                right = mid;
                while(left > 0 && nums[left-1] == target) left--;
                while(right < nums.length - 1 && nums[right+1] == target) right++;
                break;
            }
            else if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return find ? new int[]{left, right} : new int[]{-1, -1};
    }
    
    /*
     * Solution: Real Binary Search
     * Time Complexity: O(logN)
     * Space Complexity: O(1)
     */
    public int[] searchRange2(int[] nums, int target) {
        int left = findFirst(nums, target);
        int right = findLast(nums, target, left);
        return new int[]{left, right};
    }
    
    public int findFirst(int[] nums, int target){
        int idx = -1;
        int left = 0, right = nums.length-1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
            
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
    
    public int findLast(int[] nums, int target, int start){
        int idx = -1;
        int left = start, right = nums.length-1;
        if(left == -1) return -1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
            
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}
