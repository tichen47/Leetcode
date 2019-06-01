package dynamic_programming;

public class House_Robber_198 {
    /*
     * Solution: DP
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = nums[0];

        for(int i = 1; i < nums.length; i++){
            int cur = Math.max(prev2, prev1 + nums[i]);
            prev1 = prev2;
            prev2 = cur;
        }
        return prev2;
    }
    
    /*
     * Solution: DP
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int rob2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int i = 1; i < n; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        return dp[n];
    }
    
    /*
     * Solution: DP
     * Time Complexity: O(N)
     * Space Complexity: O(2N)
     */
    public int rob3(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp_t = new int[n];
        int[] dp_f = new int[n];
        
        dp_t[0] = nums[0];
        dp_f[0] = 0;
        
        for(int i = 1; i < nums.length; i++){
            dp_t[i] = nums[i] + dp_f[i-1];
            dp_f[i] = Math.max(dp_t[i-1], dp_f[i-1]);
        }
        return Math.max(dp_t[n-1], dp_f[n-1]);
    }
}
