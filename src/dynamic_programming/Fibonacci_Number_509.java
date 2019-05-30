package dynamic_programming;

public class Fibonacci_Number_509 {
    /*
     * Solution: DP
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */ 
    public int fib(int N) {
        if(N == 0 || N == 1) return N;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= N; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[N];
    }
    
    /*
     * Solution: Recursive
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */  
    public int fib2(int N) {
        if(N == 0 || N == 1) return N;
        return fib2(N-1) + fib2(N-2);
    }
    
    
}
