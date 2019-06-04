package dynamic_programming;

public class Coin_Change_322 {
    /*
     * Solution: DP
     * Time Complexity: O(N * C) 
     * Space Complexity: O(C) C: amount
     */ 
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;

        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++)
            dp[i] = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int value = coins[i];

            if (value > amount) continue;
            else if (value == amount) return 1;

            dp[value] = 1;
            for (int j = value + 1; j <= amount; j++) {
                if (dp[j - value] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - value] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
