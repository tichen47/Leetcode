package search;

public class Find_the_Duplicate_Number_287 {
    /*
     * Solution: Two Pointer
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        
        while(fast != slow){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;

        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
    
    /*
     * Solution: Iterative Binary Search
     * Time Complexity: O(logN)
     * Space Complexity: O(1)
     */
    public int findDuplicate2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            int count = 0;
            for(int num : nums){
                if(num <= mid) count++;
            }
            if(count > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
