package dynamic_programming;

public class Perfect_Squares_279 {
    
    /*
     * Solution 1: DP 
     * Time Complexity: O(NlogN) 
     * Space Complexity: O(N)
     */
    public int numSquares(int n) {
        int[] record = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            record[i] = i;
            for (int j = 1; j * j <= i; j++) {
                record[i] = Math.min(record[i], record[i - j * j] + 1);
            }
        }
        return record[n];
    }
}
