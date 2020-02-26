package dynamic_programming;

import java.util.*;

public class Number_of_Paths_with_Max_Score_1301 {
    public int[] pathsWithMaxScore(List<String> board) {
        if(board == null) return new int[]{0, 0};

        final int MOD = (int)1e9 + 7;
        int n = board.size();

        // dp[i][j][0] is the maximum sum, dp[i][j][1] is the number of such sum
        // use n + 1 to avoid index out range
        // set path sum of character 'S' to 1
        int[][][] dp = new int[n + 1][n + 1][2];
        dp[n - 1][n - 1][1] = 1;


        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {1, 1}};

        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                char ch = board.get(i).charAt(j);

                if(ch == 'X' || ch == 'S') continue;
                int num = ch == 'E' ? 0 : ch - '0';

                int max = Math.max(dp[i+1][j+1][0], Math.max(dp[i+1][j][0], dp[i][j+1][0]));
                for(int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if(dp[ni][nj][0] == max)
                        dp[i][j][1] = (dp[i][j][1] + dp[ni][nj][1]) % MOD;
                }

                dp[i][j][0] = max + num;
            }
        }
        return dp[0][0][1] == 0 ? new int[]{0, 0} : dp[0][0];
    }
}
