package dynamic_programming;

public class Coin_Change_2_518 {
    /*
     * Solution: DP
     * N: # of coins, M: amount
     * Time Complexity: O(MN)
     * Space Complexity: O(M)
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins) {
            for(int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
