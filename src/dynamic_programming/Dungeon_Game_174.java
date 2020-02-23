package dynamic_programming;

public class Dungeon_Game_174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null) return 1;

        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = Math.max(1- dungeon[m-1][n-1], 1);

        for(int i = m - 2; i >= 0; i--) {
            dp[i][n-1] = Math.max(dp[i+1][n-1] - dungeon[i][n-1], 1);
        }

        for(int j = n - 2; j >= 0; j--) {
            dp[m-1][j] = Math.max(dp[m-1][j+1] - dungeon[m-1][j], 1);
        }

        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                int down = Math.max(dp[i+1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j+1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[0][0];
    }
}
