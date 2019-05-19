package heap;

import java.util.*;

public class Last_Stone_Weight_1046 {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for(int i = 0; i < stones.length; i++){
            heap.add(stones[i]);
        }
        while(heap.size() > 1){
            int a = heap.poll();
            int b = heap.poll();
            if(a != b) heap.add(a - b);
        }
        return heap.size() == 1 ? heap.poll() : 0;
    }
}
