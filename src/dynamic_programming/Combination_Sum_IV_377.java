package dynamic_programming;

import java.util.*;

public class Combination_Sum_IV_377 {
    // Key: comb[target] = comb[target - nums[0]] + comb[target - nums[1] ...
    
    // Simple Recursive: Time Limt Exceeded
    public int combinationSum4(int[] nums, int target) {
        if(target == 0) return 1;
        
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(target - nums[i] >= 0)
                res += combinationSum4(nums, target - nums[i]);
        }
        return res;
    }
    
    // Memoization: Top down
    int[] memo;
    
    public int combinationSum42(int[] nums, int target) {
        memo = new int[target+1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return help(nums, target);
    }
    
    public int help(int[] nums, int target){
        
        if(memo[target] != -1) return memo[target];
        
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(target - nums[i] >= 0)
                res += help(nums, target - nums[i]);
        }
        memo[target] = res;
        return res;
    }
    
    // DP: Bottom up
    public int combinationSum43(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if(i - nums[j] >= 0)
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
