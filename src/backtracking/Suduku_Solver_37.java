package backtracking;

public class Suduku_Solver_37 {
    /*
     * Solution: Backtracking DFS
     * N: the number of empty cell 
     * Time Complexity: O(9^N)
     * Space Complexity: O(N): Recursive space
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Once find next empty cell
                if (board[i][j] == '.') {
                    for (char value = '1'; value <= '9'; value++) {
                        if (valid(board, i, j, value)) {
                            board[i][j] = value;

                            if (solve(board))
                                return true;

                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean valid(char[][] board, int row, int col, char value) {
        int blockRow = row / 3 * 3;
        int blockCol = col / 3 * 3;
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value || board[row][i] == value || board[blockRow + i / 3][blockCol + i % 3] == value)
                return false;
        }
        return true;
    }
}
