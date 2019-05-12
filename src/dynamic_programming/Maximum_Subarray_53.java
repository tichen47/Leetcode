package dynamic_programming;

public class Maximum_Subarray_53 {

    /*
     * Solution: DP
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] > 0)
                nums[i] += nums[i - 1];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
