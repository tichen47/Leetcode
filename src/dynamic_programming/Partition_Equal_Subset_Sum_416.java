package dynamic_programming;

public class Partition_Equal_Subset_Sum_416 {
    /*
     * Solution: DP
     * Time Complexity: O(N * C) 
     * Space Complexity: O(C) C: half of sum
     */ 
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums)
            sum += num;
        
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        
        dp[0] = true;
        
        for(int i = 0; i < n; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
    
    /*
     * Solution: Memoization
     * Time Complexity: ?
     * Space Complexity: O(N * C) 
     */ 
    Boolean[][] memo;
    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for(int num : nums)
            sum += num;
        
        if(sum % 2 != 0) return false;
        
        int target = sum / 2;
        memo = new Boolean[n][target+1];
        
        return canPartition(nums, target, n-1);
    }
    
    public boolean canPartition(int[] nums, int target, int index){
        if(target == 0) return true;
        if(index < 0 || target < 0 || target < nums[index]) return false;

        if(memo[index][target] != null) return memo[index][target];
        
        memo[index][target] = canPartition(nums, target, index-1) 
            || canPartition(nums, target-nums[index], index-1);
        
        return memo[index][target];
    }
}
