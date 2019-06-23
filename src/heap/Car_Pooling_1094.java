package heap;

import java.util.*;

public class Car_Pooling_1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        
        Queue<Time> pq = new PriorityQueue<>((v1, v2) -> v1.time - v2.time);
        for(int[] trip : trips){
            pq.offer(new Time(0, trip[1], trip[0]));
            pq.offer(new Time(1, trip[2], trip[0]));
        }
        
        int curCap = 0;
        while(!pq.isEmpty()){
            int cur = pq.peek().time;
            while(!pq.isEmpty() && pq.peek().time == cur) {
                Time event = pq.poll();
                if(event.p == 0) curCap += event.num;
                else curCap -= event.num;
            }
            if(curCap > capacity) return false;
        }
        return true;
    }
    
    class Time {
        int p; // 0 for start, 1 for end
        int time;
        int num;
        public Time(int p, int time, int num){
            this.p = p;
            this.time = time;
            this.num = num;
        }
    }
}
