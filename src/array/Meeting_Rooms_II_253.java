package array;

import java.util.*;

public class Meeting_Rooms_II_253 {
    /*
     * Solution: 
     * Time Complexity: O(NlogN) 
     * Space Complexity: O(N)
     */
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length < 1) return 0;
        
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for(int i = 0; i < n; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int rooms = 0;
        int endIndex = 0;
        for(int i = 0; i < n; i++){
            if(starts[i] < ends[endIndex])
                rooms++;
            else
                endIndex++;
        }
        return rooms;
    }
}
