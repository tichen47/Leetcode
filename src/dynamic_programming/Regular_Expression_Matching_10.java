package dynamic_programming;

public class Regular_Expression_Matching_10 {
    /*
     * Solution: DP
     * Time Complexity: O(MN)
     * Space Complexity: O(MN)
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        s = " " + s;
        p = " " + p;
        dp[0][0] = true;
        
        for(int i = 0; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i > 0 && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'))
                    dp[i][j] = dp[i][j] || dp[i-1][j-1];
                
                if(p.charAt(j) == '*'){
                    dp[i][j] = dp[i][j] || dp[i][j-2];
                    if(i > 0 && (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.'))
                        dp[i][j] = dp[i][j] || dp[i-1][j-2] || dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
