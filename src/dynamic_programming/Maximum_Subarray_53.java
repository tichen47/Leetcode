package dynamic_programming;

public class Maximum_Subarray_53 {
    
    /*
     * Solution:
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        if(nums == null) return 0;
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > 0)
                nums[i] += nums[i-1];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
