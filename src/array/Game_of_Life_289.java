package array;

public class Game_of_Life_289 {
    public void gameOfLife(int[][] board) {
        /*
         * Solution:
         * Time Complexity: O(MN)
         * Space Complexity: O(1) : In-place
         * Use two bits to represent status: 00, 01, 10, 11
         * First bit: Current
         * Second bit: Next
         * 0 for die, 1 for live: 10 indicates die -> live
         * To get current status: board[i][j] & 1
         * To get next status: board[i][j] << 1
         */
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int liveN = liveNeighbors(board, i, j, m, n);
                if(board[i][j] == 1 && liveN >= 2 && liveN <= 3)
                    board[i][j] = 3;
                else if(liveN == 3)
                    board[i][j] = 2;
            }
        }

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                board[i][j] >>= 1;
    }

    public int liveNeighbors(int[][] board, int x, int y, int m, int n) {
        int num = 0;
        for(int i = Math.max(0, x - 1); i < Math.min(x + 2, m); i++) {
            for(int j = Math.max(0, y - 1); j < Math.min(y + 2, n); j++)
                num += board[i][j] & 1; // Take the first bit
        }
        num -= board[x][y] & 1;
        return num;
    }
}
