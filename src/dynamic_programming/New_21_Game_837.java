package dynamic_programming;

public class New_21_Game_837 {
    /*
     * Solution 1: DP
     * Time Complexity: O(N)
     * Space Complexity: O(N + W)
     */
    public double new21Game(int N, int K, int W) {
        if(K == 0 || N >= K + W) return 1;

        double[] dp = new double[N + 1];
        double wSum = 1, res = 0;
        dp[0] = 1.0;

        for(int i = 1; i <= N; i++) {
            dp[i] = wSum / W;
            if(i < K)
                wSum += dp[i];
            else
                res += dp[i];

            if(i - W >= 0)
                wSum -= dp[i - W];
        }
        return res;
    }
}
