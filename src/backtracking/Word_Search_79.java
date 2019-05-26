package backtracking;

public class Word_Search_79 {
    /*
     * Solution: Backtracking
     * Time Complexity:  O(M * N * (4^L)) : M*N is the size of the board, 4^L for each cell
     * Space Complexity: O(L): L is the length of the word
     */ 
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;
        if (board == null)
            return false;

        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && exist(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int start, int x, int y) {
        // Finish compare
        if (start == word.length())
            return true;

        // Out of bound
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return false;

        // Already in the set
        if (visited[x][y])
            return false;

        // Value not equal
        if (word.charAt(start) != board[x][y])
            return false;

        visited[x][y] = true;

        if (exist(board, word, start + 1, x - 1, y) || exist(board, word, start + 1, x, y + 1)
                || exist(board, word, start + 1, x + 1, y) || exist(board, word, start + 1, x, y - 1))
            return true;

        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] { { 'a', 'b' } };
        String word = "ba";
        Word_Search_79 w = new Word_Search_79();
        System.out.println(w.exist(board, word));
    }
}
