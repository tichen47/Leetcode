package array;

public class Find_Celebrity_277 {
    int[][] graph;

    /*
     * Solution 1: 
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public int findCelebrity(int n) {

        int cel = 0;
        /*
         * Step 1: Find the only candidate Hint: The celebrity don't know anyone, but
         * everyone knows him
         */
        for (int i = 0; i < n; i++) {
            if (knows(cel, i))
                cel = i;
        }

        /*
         * Test if the candidate is the celebrity
         */
        for (int i = 0; i < n; i++) {
            if (i != cel && knows(cel, i) || !knows(i, cel))
                return -1;
        }
        return cel;
    }
    
    public boolean knows(int a, int b) {
        return graph[a][b] == 1;
    }

    public void set_graph() {
        graph = new int[][] { 
            { 1, 1 }, 
            { 1, 1 }
        };
    }

    public static void main(String[] args) {
        Find_Celebrity_277 t = new Find_Celebrity_277();
        t.set_graph();
        System.out.println(t.findCelebrity(2));
    }

}
