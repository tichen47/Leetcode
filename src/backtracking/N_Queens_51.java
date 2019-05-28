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
    List<List<String>> ret;
    char[][] board;   // Current board
    boolean[] column; 
    boolean[] dia1;   // Left to right  index = row + col
    boolean[] dia2;   // Right to left  index = row - col + n - 1
    
    public List<List<String>> solveNQueens(int n) {
        ret = new ArrayList<>();
        column = new boolean[n];
        dia1 = new boolean[n * 2 - 1];
        dia2 = new boolean[n * 2 - 1];
        board = new char[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        }
        
        putQueens(0, n);
        return ret;
    }
    
    public void putQueens(int index, int n){
        if(index == n){
            addResult(n);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(!column[i] && !dia1[index + i] && !dia2[index - i + n - 1]){
                column[i] = true;
                dia1[index + i] = true;            
                dia2[index - i + n - 1] = true;
                board[index][i] = 'Q';               
                
                putQueens(index+1, n);
                
                column[i] = false;
                dia1[index + i] = false;            
                dia2[index - i + n - 1] = false;
                board[index][i] = '.';               
            }
        }
    }
    
    public void addResult(int n){
        List<String> solution = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String rowStr = String.valueOf(board[i]);
            solution.add(rowStr);
        }
        ret.add(solution);
    }
}
