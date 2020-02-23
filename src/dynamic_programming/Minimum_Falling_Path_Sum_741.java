package dynamic_programming;

public class Minimum_Falling_Path_Sum_741 {
    /*
     * Solution 1: DP
     * Time Complexity: O(NN)
     * Space Complexity: O(1)
     */
    public int minFallingPathSum(int[][] A) {

        int n = A.length;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int curMin = A[i-1][j];
                if(j > 0) curMin = Math.min(curMin, A[i-1][j-1]);
                if(j < n - 1) curMin = Math.min(curMin, A[i-1][j+1]);
                A[i][j] += curMin;
            }
        }

        int res = Integer.MAX_VALUE;
        for(int num : A[n-1])
            res = Math.min(res, num);
        return res;
    }
}
