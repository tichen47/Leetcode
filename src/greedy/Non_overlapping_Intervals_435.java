package greedy;

import java.util.*;

public class Non_overlapping_Intervals_435 {
    /*
     * Solution: Greedy
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        
        // Sort based on the end time
        // Keep the intervals with the minimum end time, and the start time greater than previous end time 
        int n = intervals.length;
        Arrays.sort(intervals, (v1, v2) -> v1[1] - v2[1]);
        
        int end = Integer.MIN_VALUE;
        int erase = 0;
        for(int i = 0; i < n; i++){
            if(intervals[i][0] >= end){
                end = intervals[i][1];
            }
            else erase++;
        }
        return erase;
    }
    
    /*
     * Solution: DP 
     * Time Complexity: O(N^2) 
     * Space Complexity: O(N)
     */
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        int n = intervals.length;
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[j][1] <= intervals[i][0])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 1;
        for (int i = 0; i < n; i++)
            res = Math.max(res, dp[i]);
        return n - res;
    }
}
