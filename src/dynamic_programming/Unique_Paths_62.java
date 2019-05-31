package dynamic_programming;

public class Unique_Paths_62 {
    /*
     * Solution: DP
     * Time Complexity: O(M * N) 
     * Space Complexity: O(M * N)
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    
    /*
     * Solution: Math
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public int uniquePaths2(int m, int n) {
        // m-1 step right and n-1 step down to reach the "Finish"
        // So: m--, n-- 
        // Permutation: res = (m + n)! / (m!)(n!)
        if(m == 1 || n == 1) return 1;
        m--;
        n--;
        
        // Make sure m is bigger
        if(m < n){
            int temp = m;
            m = n;
            n = temp;
        }
        
        // Calculate
        long res = 1;
        for(int i = 1; i <= n; i++){
            res *= (i + m);
            res /= i;
        }
        return (int)res;
    }
}
