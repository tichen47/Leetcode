package dynamic_programming;

public class Maximal_Square_221 {
    /*
     * Solution 1: DP
     * Time Complexity: O(MN)
     * Space Complexity: O(MN)
     */
    public int maximalSquare(char[][] A) {
        if(A.length == 0) return 0;

        int res = 0, m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j ==0)
                    dp[i][j] = A[i][j] -'0';
                else if(A[i][j] == '1')
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}
