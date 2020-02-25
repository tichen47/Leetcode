package dynamic_programming;

import java.util.*;

public class Minimum_Falling_Path_Sum_II_1289 {
    /*
     * Solution 1: DP
     * Time Complexity: O(N^3)
     * Space Complexity: O(N^2)
     */
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int curMin = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++) {
                    if(j != k) {
                        curMin = Math.min(curMin, arr[i-1][k]);
                    }
                }
                arr[i][j] += curMin;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int num : arr[n-1])
            res = Math.min(res, num);
        return res;
    }

    /*
     * Solution 2: DP
     * Time Complexity: O(N^2)
     * Space Complexity: O(N^2)
     */
    public int minFallingPathSum2(int[][] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {

            // Get the first and second min value
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int j = 0; j < n; j++)
                pq.offer(arr[i-1][j]);
            int firstMin = pq.poll();
            int secMin = pq.poll();

            // add secMin if the previous raw in same cloumn is firstMin
            // otherwise add firstMin
            for(int j = 0; j < n; j++)
                arr[i][j] += arr[i-1][j] == firstMin ? secMin : firstMin;
        }

        int res = Integer.MAX_VALUE;
        for(int num : arr[n-1])
            res = Math.min(res, num);
        return res;
    }
}
