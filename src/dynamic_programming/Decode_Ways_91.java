package dynamic_programming;

public class Decode_Ways_91 {
    /*
     * Solution: DP back to front
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = s.charAt(n-1) == '0' ? 0 : 1;
        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i) == '0') continue;
            dp[i] = Integer.valueOf(s.substring(i, i+2)) <= 26 ? dp[i+1] + dp[i+2] : dp[i+1];
        }
        return dp[0];
    }
    
    
    /*
     * Solution: DP front to end
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public int numDecodings2(String s) {
        int n = s.length();
        if(n == 0) return 0;
        
        int[] dp = new int[n+1];
        
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 1; i < n; i++){
            // Single Character
            if(s.charAt(i) == '0') 
                dp[i] = 0;
            else
                dp[i] = dp[i-1];
            
            // Double Characters
            int twoChar = Integer.valueOf(s.substring(i-1, i+1));
            if(twoChar <= 26 && twoChar >= 10){
                if(i == 1) dp[i] += 1;
                else dp[i] += dp[i-2];
            }
        }
        return dp[n-1];
    }
}
