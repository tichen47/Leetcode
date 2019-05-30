package dynamic_programming;

public class Minimum_Path_Sum_64 {
    /*
     * Solution: DP
     * Time Complexity: O(N * M) 
     * Space Complexity: O(1)
     */ 
    public int minPathSum(int[][] grid) {
        int m = grid.length;    // length of column
        int n = grid[0].length; // length of row
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // First row
                if(i == 0 && j != 0) 
                    grid[i][j] += grid[i][j-1];
                // First col
                else if(i != 0 && j == 0)
                    grid[i][j] += grid[i-1][j];
                // Other index without (0,0)
                else if(i != 0 && j != 0)
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
