package heap;

import java.util.*;

public class Distant_Barcodes_1054 {
    /*
     * Solution: 
     * Time Complexity: O(3N) -> O(N)  
     * Space Complexity: O(3N) -> O(N)
     */ 
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        // Store in a HashMap
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : barcodes)
            map.put(num, map.getOrDefault(num, 0) + 1);    

        // Create a PriorityQueue compare count in descending order
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        
        // Convert the HashMap into the PriorityQueue
        for(Map.Entry<Integer, Integer> item : map.entrySet()){
            pq.offer(new Pair(item.getKey(), item.getValue()));
        }
        
        // Create the return array
        int[] ret = new int[barcodes.length];
        int index = 0;
        while(pq.size() >= 2){
            Pair a = pq.poll();
            Pair b = pq.poll();
            
            ret[index++] = a.value;
            if(a.count > 1){
                a.count -= 1;
                pq.offer(a);
            }
            
            ret[index++] = b.value;
            if(b.count > 1){
                b.count -= 1;
                pq.offer(b);
            }
        }
        
        if(!pq.isEmpty()) ret[index] = pq.poll().value;
        return ret;
    }
    
    class Pair {
        int value;
        int count;
        public Pair(int value, int count){
            this.value = value;
            this.count = count;
        }
    }
}
