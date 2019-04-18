package dynamic_programming;

public class Climbing_Stairs_70 {

    
    /*
     * Solution: Brute Force
     * Time Complexity: O(2^N)
     * Space Complexity: O(1)
     */
    public int climbStairs(int n) {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        
        return climbStairs(n-1) + climbStairs(n-2);
    } 
    
    
    /*
     * Solution: Recursion with Memoization
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int climbStairs2(int n) {
        int[] mem = new int[n+2];
        
        return help(n, 0, mem);
    }   
    
    public int help(int n, int i, int[] mem){
        if(i == n)
            return 1;
        else if(i > n)
            return 0;
        
        if(mem[i+1] == 0)
            mem[i+1] = help(n, i+1, mem);
        if(mem[i+2] == 0)
            mem[i+2] = help(n, i+2, mem);
        return mem[i+1] + mem[i+2];
    }
    
    /*
     * Solution: Dynamic Programming
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int climbStairs3(int n) {
        if(n == 1)
            return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n-1];
    }
    
    /*
     * Solution: Fibonacci
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int climbStairs4(int n) {
        if(n == 1)
            return 1;
        int a = 1;
        int b = 2;
        int c;
        for(int i = 2; i < n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
