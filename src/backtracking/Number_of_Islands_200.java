package backtracking;

public class Number_of_Islands_200 {
    /*
     * Solution: Floodfill DFS
     * Time Complexity: O(M * N) 
     * Space Complexity: O(M * N)
     */ 
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    floodFill(grid, i, j);
                    num++;
                } 
            } 
        }
        return num;
    }
    
    public void floodFill(char[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') return;
        
        grid[x][y] = '2';  // Marked as filled already, can be anything rather than '1'
        
        floodFill(grid, x-1, y);  // Up
        floodFill(grid, x, y+1);  // Right
        floodFill(grid, x+1, y);  // Down
        floodFill(grid, x, y-1);  // Left
    }
}
