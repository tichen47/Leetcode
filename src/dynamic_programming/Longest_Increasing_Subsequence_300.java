package dynamic_programming;

import java.util.*;

public class Longest_Increasing_Subsequence_300 {
    /*
     * Solution: Recursion with Memoization
     * Time Complexity: O(N^2) 
     * Space Complexity: O(N)
     */ 
    int[] memo;
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        memo = new int[len];
        memo[0] = 1;
        
        int res = 0;
        for(int i = 0; i < len; i++){
            res = Math.max(res, lis(nums, i));
        }
        return res;
    }
    
    public int lis(int[] nums, int index){  
        if(memo[index] != 0) 
            return memo[index];
        
        memo[index] = 1;
        for(int i = 0; i < index; i++){
            if(nums[index] > nums[i]) 
                memo[index] = Math.max(memo[index], lis(nums, i) + 1);
        }
        
        return memo[index];
    }
    
    /*
     * Solution: DP
     * Time Complexity: O(N^2) 
     * Space Complexity: O(N)
     */ 
    public int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        
        int res = 1;
        for(int i = 1; i < len; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    /*
     * Solution: DP with binary search
     * Time Complexity: O(N^2) 
     * Space Complexity: O(N)
     */ 
    public int lengthOfLIS3(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        
        for(int num : nums){
            // BinarySearch: return positive value if found, negative value if not found
            // If not found, the insert position is -(i+1)
            int i = Arrays.binarySearch(dp, 0, len, num);
            if(i < 0){ 
                i = -(i + 1);
            }
            dp[i] = num;
            if(i == len){
                len++;
            }
        }
        return len;
    }
}
