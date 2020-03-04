package dynamic_programming;

public class Keys_Keyboard_2_650 {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            dp[i] = i; // at most i step
            for(int j = i / 2; j > 1; j--) {
                if(i % j == 0) {
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }
        return dp[n];
    }
}
