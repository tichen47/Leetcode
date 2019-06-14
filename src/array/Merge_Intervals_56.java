package array;

import java.util.*;

public class Merge_Intervals_56 {
    /*
     * Solution: 
     * Time Complexity: O(NlogN) 
     * Space Complexity: O(N)
     */
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        
        List<int[]> ls = new ArrayList<>();
        int[] cur = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= cur[1]){
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
            else{
                ls.add(cur);
                cur = intervals[i];
            }
        }
        ls.add(cur);
        
        return ls.toArray(new int[ls.size()][]);
    }
}
