package dynamic_programming;

public class Unique_Paths_II_63 {
    /*
     * Solution: DP
     * Time Complexity: O(M * N) 
     * Space Complexity: O(M * N)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(obstacleGrid[i][j] == 1)  // obstacles
                    dp[i][j] = 0;
                else if(i == 0 && j == 0)    // left up corner
                    dp[i][j] = 1;
                else if(i == 0)              // first row
                    dp[i][j] = dp[i][j-1];  
                else if(j == 0)              // first column
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
    
    /*
     * Solution: DP with O(N) space 
     * Time Complexity: O(M * N) 
     * Space Complexity: O(N)
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}
