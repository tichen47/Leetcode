package dynamic_programming;

public class House_Robber_II_213 {
    /*
     * Solution: DP
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int rob(int[] nums) {
        // Algorithm: find the maxRob with first house, and maxRob without first house, return the bigger one
        if(nums.length == 0) return 0;
        int n = nums.length;
        int prev1 = 0, prev2 = nums[0];  // rob first house
        int prev3 = 0, prev4 = 0;        // skip first house
        
        for(int i = 1; i < nums.length - 1; i++){
            int cur1 = Math.max(prev2, prev1 + nums[i]);
            prev1 = prev2;
            prev2 = cur1;
            
            int cur2 = Math.max(prev4, prev3 + nums[i]);
            prev3 = prev4;
            prev4 = cur2;
        }
        
        int maxRobFirst = prev2;
        int maxSkipFirst = Math.max(prev4, prev3 + nums[n-1]);
        
        return Math.max(maxRobFirst, maxSkipFirst);
    }
    
    /*
     * Solution: DP
     * Time Complexity: O(2N)
     * Space Complexity: O(1)
     */
    public int rob2(int[] nums) {
        // Algorithm: find the maxRob with house[0,n-1), and house[1, n). return the bigger one
        int n = nums.length;
        
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        int robFirst = maxRob(nums, 0, n-1);
        int skipFirst = maxRob(nums, 1, n);
        
        return Math.max(robFirst, skipFirst);
    }
    
    // Consider rob house [start, end)
    public int maxRob(int[] nums, int start, int end){
        int prev1 = 0;
        int prev2 = nums[start];
        for(int i = start + 1; i < end; i++){
            int cur1 = Math.max(prev2, prev1 + nums[i]);
            prev1 = prev2;
            prev2 = cur1;
        }
        return prev2;
    }
}
