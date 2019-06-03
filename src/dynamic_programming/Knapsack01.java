package dynamic_programming;

/*
 * 0/1 Knapsack Problem
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. 
 * Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
 * You cannot break an item, either pick the complete item, or don¡¯t pick it (0-1 property).
 */
public class Knapsack01 {
    /*
     * Memoization
     */
    int[][] memo;

    /**
     * @param w weight
     * @param v value
     * @param C capacity
     * @return maximum value
     */
    public int knapsack(int[] w, int[] v, int C) {
        int n = w.length;

        memo = new int[n][C + 1];

        return bestValue(w, v, C, n - 1);
    }

    // Use item in [0 ... index] to fill the knapsack
    public int bestValue(int[] w, int[] v, int C, int index) {
        if (index < 0 || C <= 0)
            return 0;

        if (memo[index][C] != 0)
            return memo[index][C];

        // Doesnot put item[index] into the knapsack
        int res = bestValue(w, v, C, index - 1);

        // Put item[index] into the knapsack
        if (C >= w[index])
            res = Math.max(res, v[index] + bestValue(w, v, C - w[index], index - 1));

        memo[index][C] = res;
        return res;
    }

    /*
     * DP
     */
    public int knapsack2(int[] w, int[] v, int C) {
        int n = w.length;
        int[][] dp = new int[n][C + 1];

        for (int i = 0; i <= C; i++) {
            dp[0][i] = w[0] <= i ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                // If not put current item
                dp[i][j] = dp[i - 1][j];

                // If put current item
                if (w[i] <= j) {  // j is the current capacity
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }
        return dp[n - 1][C];
    }

    public static void main(String[] args) {
        int[] w = new int[] { 1, 2, 3 };
        int[] v = new int[] { 6, 10, 12 };
        int C = 5;

        Knapsack01 k = new Knapsack01();

        // Test: Memoization
        int ans = k.knapsack(w, v, C);
        System.out.println(ans);

        // Test: DP
        int ans2 = k.knapsack2(w, v, C);
        System.out.println(ans2);
    }
}
