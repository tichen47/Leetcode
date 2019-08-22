package backtracking;

import java.util.*;

public class Matchsticks_to_Square_473 {
    /*
     * Solution: Backtracking DFS
     * N: the length of nums
     * Time Complexity: O(4^N)
     * Space Complexity: O(N): Recursive space
     */
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length < 4) return false;
        
        // Sort adn use the big number first to save time
        // Reason: we always try to put the next matchstick in the first subset. 
        // If there is no solution, trying a longer matchstick first will get to negative conclusion earlier.
        Arrays.sort(nums);
        
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 4 != 0) return false;
        return dfs(nums, new int[4], nums.length - 1, sum / 4);
    }
    
    public boolean dfs(int[] nums, int[] sums, int index, int sideLen){
        if(index == -1) return true;
        
        for(int i = 0; i < 4; i++){
            if(nums[index] + sums[i] > sideLen) continue;
            sums[i] += nums[index];
            if(dfs(nums, sums, index - 1, sideLen)) return true;
            sums[i] -= nums[index];
        }
        return false;
    }
}
