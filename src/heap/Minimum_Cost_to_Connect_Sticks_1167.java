package heap;

import java.util.*;

public class Minimum_Cost_to_Connect_Sticks_1167 {

    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick : sticks) pq.add(stick);
        int sum = 0;
        while(pq.size() != 1){
            int newStick = pq.remove() + pq.remove();
            sum += newStick;
            pq.add(newStick);
        }
        return sum;
    }
}
