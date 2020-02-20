package dynamic_programming;

public class Count_Square_Submatrices_with_All_Ones_1277 {
    /*
     * Solution 1: DP
     * Time Complexity: O(MN)
     * Space Complexity: O(MN)
     */
    public int countSquares(int[][] A) {
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 1 && i > 0 && j > 0) {
                    A[i][j] = Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i][j-1])) + 1;
                }
                res += A[i][j];
            }
        }
        return res;
    }
}
