package backtracking;

public class Surrounded_Regions_130 {
    /*
     * Solution: Floodfill DFS
     * Time Complexity: O(M * N) 
     * Space Complexity: O(M * N)
     */ 
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int x = board.length;
        int y = board[0].length;
        
        // First and last horizontal line
        for(int i = 0; i < x; i++){
            if(board[i][0] == 'O')
                floodFill(board, i, 0);
            if(board[i][y-1] == 'O')
                floodFill(board, i, y-1);
        }
        
        // First and last vertical line 
        for(int i = 0; i < y; i++){
            if(board[0][i] == 'O')
                floodFill(board, 0, i);
            if(board[x-1][i] == 'O')
                floodFill(board, x-1, i);
        }
        
        // Convert 'E' to 'O', 'O' to 'X'
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(board[i][j] == 'E')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
    
    public void floodFill(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        
        board[i][j] = 'E'; // Edge
        floodFill(board, i-1, j);
        floodFill(board, i, j+1);
        floodFill(board, i+1, j);
        floodFill(board, i, j-1);
    }
}
