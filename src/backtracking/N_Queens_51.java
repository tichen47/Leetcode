package backtracking;

import java.util.*;

public class N_Queens_51 {
    /*
     * Solution: Backtracking DFS
     * Time Complexity: O(N! * N)
     * Space Complexity: O(N)
     * 
     * 
     * Explaination for time complexity:
     * N possibilities to put the first queen
     * N(N-2) to put two queens
     * N(N-2)(N-4) to put three queens
     * Thus the time complexity for put queens is O(N!)
     * Times the O(N) for function 'addRusult'
     * Total time complexity: O(N! * N)
     */ 
    boolean[] col;
    boolean[] hill; // low to high: row + col = const
    boolean[] dale; // high to low: row - col = const
    
    List<List<String>> res;
    char[][] board;
    
    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        hill = new boolean[n * 2 - 1];
        dale = new boolean[n * 2 - 1];
        res = new ArrayList<>();
        board = new char[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        }
        putQueen(0, n);
        return res;
    }
    
    public void putQueen(int row, int n) {
        if(row == n){ 
            add2Res(n);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(col[i] || hill[i + row] || dale[row - i + n - 1]) continue;
            setBoard(row, i, true, n);
            putQueen(row + 1, n);
            setBoard(row, i, false, n);
        }
    }
    
    public void add2Res(int n) {
        List<String> sol = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String row = String.valueOf(board[i]);
            sol.add(row);
        }
        res.add(sol);
    }
    
    public void setBoard(int r, int c, boolean status, int n){
        board[r][c] = status == true ? 'Q' : '.';
        col[c] = status;
        hill[r + c] = status;
        dale[r - c + n - 1] = status;
    }
}
