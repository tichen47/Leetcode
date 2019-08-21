package backtracking;

public class N_Queens_II_52 {
    boolean[] col;
    boolean[] hill; // low to high: row + col = const
    boolean[] dale; // high to low: row - col = const
    int res;
    
    public int totalNQueens(int n) {
        col = new boolean[n];
        hill = new boolean[n * 2 - 1];
        dale = new boolean[n * 2 - 1];
        res = 0;
        
        putQueen(0, n);
        return res;
    }
    
    public void putQueen(int row, int n) {
        if(row == n){ 
            res++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(col[i] || hill[i + row] || dale[row - i + n - 1]) continue;
            setBoard(row, i, true, n);
            putQueen(row + 1, n);
            setBoard(row, i, false, n);
        }
    }
    
    
    public void setBoard(int r, int c, boolean status, int n) {
        col[c] = status;
        hill[r + c] = status;
        dale[r - c + n - 1] = status;
    }
}
