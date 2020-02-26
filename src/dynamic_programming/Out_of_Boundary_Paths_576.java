package dynamic_programming;

public class Out_of_Boundary_Paths_576 {
    /*
     * Solution 1: DP
     * Time Complexity: O(Nmn)
     * Space Complexity: O(mn)
     */
    public int findPaths(int m, int n, int N, int i, int j) {
        if(N < 0) return 0;
        else if(isOut(m, n, i, j)) return 1;

        final int MOD = 1000000007;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int res = 0;

        for(int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for(int r = 0; r < m; r++) {
                for(int c = 0; c < n; c++) {
                    for(int[] dir : dirs) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if(isOut(m, n, nr, nc)) {
                            res = (res + count[r][c]) % MOD;
                        } else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
                        }
                    }
                }
            }
            count = temp;
        }
        return res;
    }

    public boolean isOut(int m, int n, int i, int j) {
        return i < 0 || i >= m || j < 0 || j >= n;
    }
}
