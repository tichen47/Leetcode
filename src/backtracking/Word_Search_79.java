package backtracking;

public class Word_Search_79 {
    /*
     * Solution: Backtracking
     * Time Complexity:  O(M * N * (4^L)) : M*N is the size of the board, 4^L for each cell
     * Space Complexity: O(L): L is the length of the word
     */ 
    char[][] board;
    boolean[][] used;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        int m = board.length;
        int n = board[0].length;
        used = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
                if(expandCenter(word, 0, i, j, m, n)) return true;
        }
        return false;
    }
    
    public boolean expandCenter(String word, int index, int i, int j, int m, int n) {
        if(index >= word.length()) return true;
        if(i < 0 || i >= m || j < 0 || j >= n || used[i][j] || word.charAt(index) != board[i][j]) return false;
        
        used[i][j] = true;
        
        boolean res = expandCenter(word, index+1, i+1, j, m, n)
            || expandCenter(word, index+1, i, j+1, m, n)
            || expandCenter(word, index+1, i-1, j, m, n)
            || expandCenter(word, index+1, i, j-1, m, n);
        
        used[i][j] = false;
        return res;
    }
}
