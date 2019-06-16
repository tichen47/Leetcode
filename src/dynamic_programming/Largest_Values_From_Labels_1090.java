package dynamic_programming;

import java.util.*;

public class Largest_Values_From_Labels_1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        // We basically want to find the largest values in use_limit
        // To achieve this, we want sort the value in decending order and keep their label with them
        // We can make them an array of Pair with <Value, Label>, but PriorityQueue will be more easy to use
        
        int n = values.length;
        
        // Definition of Pair class is at the bottom
        PriorityQueue<Pair> pq = new PriorityQueue<>((v1, v2) -> v2.value - v1.value);  // v2.value - v1.value makes decending order
        for(int i = 0; i < n; i++){
            pq.offer(new Pair(values[i], labels[i]));
        }
        
        // Since we can not exceed use_limit, we maintain a hashmap, the key is "Label" and value is "number already used"
        // If number_already_used equal to use limit, we need to give up current value
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        while(num_wanted > 0 && !pq.isEmpty()){  
            // Trick: sometimes num_wanted is greater than 0 but pq is already empty, we don't have more value to choice
            Pair p = pq.poll();
            int curUse = map.getOrDefault(p.label, 0);
            if(curUse < use_limit){
                sum += p.value;
                num_wanted--;
                map.put(p.label, curUse+1);
            }
        }
        return sum;
    }
    
    class Pair {
        int value;
        int label;
        public Pair(int value, int label){
            this.value = value;
            this.label = label;
        }
    }
}
