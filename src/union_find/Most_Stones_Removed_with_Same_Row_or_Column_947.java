package union_find;

import java.util.*;

public class Most_Stones_Removed_with_Same_Row_or_Column_947 {
    /*
     * Solution 1: DFS
     * Time Complexity: O(N^2)
     * Space Complexity: O(N^2)
     */
    public int removeStones(int[][] stones) {
        int numOfIsland = 0;
        Set<int[]> visited = new HashSet<>();
        for(int[] curS : stones) {
            if(!visited.contains(curS)) {
                dfs(curS, stones, visited);
                numOfIsland++;
            }
        }
        return stones.length - numOfIsland;
    }

    private void dfs(int[] curS, int[][] stones, Set<int[]> visited) {
        visited.add(curS);
        for(int[] s : stones) {
            if(!visited.contains(s) && (curS[0] == s[0] || curS[1] == s[1]))
                dfs(s, stones, visited);
        }
    }

    /*
     * Solution 2: Union find (not implemented)
     * Time Complexity:
     * Space Complexity:
     */
}
