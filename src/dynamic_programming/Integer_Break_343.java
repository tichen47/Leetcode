package dynamic_programming;

public class Integer_Break_343 {
    /*
     * Solution: DP
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            int max = i;  

            if(i == n) // n must be separate, which means it can not be its original value
                max = Integer.MIN_VALUE;
            
            for(int j = 1; j <= i / 2; j++){
                int temp = dp[j] * dp[i-j];
                max = Math.max(max, temp);
            }
            dp[i] = max;
        }
        
        return dp[n];
    }
    
    /*
     * Solution 2: Another style of solution 1
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int integerBreak2(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){ 
            for(int j = 1; j <= i / 2; j++){
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i-j, dp[i-j]));
            }
        }
        
        return dp[n];
    }
    
    /*
     * Solution 3: Math
     * Any number greater than 4 need to be break
     * Since 3 * 3 > 2 * 2 * 2, we need to have as much 3 as we can 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int integerBreak3(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int ans = 1;
        while(n > 4){
            ans *= 3;
            n -= 3;
        }
        ans *= n;
        return ans;
    }
}
