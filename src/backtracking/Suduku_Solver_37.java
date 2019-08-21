package backtracking;

public class Suduku_Solver_37 {
    /*
     * Solution: Backtracking DFS
     * N: the number of empty cell 
     * Time Complexity: O(9^N)
     * Space Complexity: O(N): Recursive space
     */
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }
    
    public boolean dfs(char[][] board, int row, int col) {
        for(int i = row; i < 9; i++, col = 0){
            for(int j = col; j < 9; j++){
                if(board[i][j] != '.') continue;
                
                for(char c = '1'; c <= '9'; c++){
                    if(isValid(board, i, j, c)){
                        board[i][j] = c;
                        if(dfs(board, i, j + 1)) return true; // Find answer
                        board[i][j] = '.';
                    }    
                }
                return false;
                
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int row, int col, char c){
        int rowBox = row / 3 * 3;
        int colBox = col / 3 * 3;
        for(int i = 0; i < 9; i++){
            if(board[row][i] == c || board[i][col] == c
              || board[rowBox + i / 3][colBox + i % 3] == c) return false;
        }
        return true;
    }
}
