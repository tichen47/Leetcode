package graph;

import java.util.*;

public class Is_Graph_Bipartite_785 {
    /*
     * Solution: BFS
     * Time Complexity: O(N + M)  N: num of nodes M: num of edges
     * Space Complexity: O(N)
     */
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(colors[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                colors[i] = 1;
                while(!queue.isEmpty()) {
                    int cur = queue.poll();
                    for(int adj : graph[cur]) {
                        if(colors[adj] == 0) {
                            colors[adj] = -colors[cur];
                            queue.offer(adj);
                        }
                        else if(colors[adj] == colors[cur]) return false;
                    }
                }
            }
        }
        return true;
    }

    /*
     * Solution: DFS
     * Time Complexity: O(N + M)  N: num of nodes M: num of edges
     * Space Complexity: O(N)
     */
    public boolean isBipartite2(int[][] graph) {
        int[] colors = new int[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(colors[i] == 0 && !isValid(graph, colors, i, 1))
                return false;
        }
        return true;
    }

    public boolean isValid(int[][] graph, int[] colors, int index, int targetColor) {
        if(colors[index] != 0)
            return colors[index] == targetColor;
        colors[index] = targetColor;
        for(int adj : graph[index]) {
            if(!isValid(graph, colors, adj, -targetColor))
                return false;
        }
        return true;
    }
}
