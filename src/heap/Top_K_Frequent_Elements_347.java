package heap;

import java.util.*;

public class Top_K_Frequent_Elements_347 {

    /*
     * Solution 1: Bucket 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        @SuppressWarnings("unchecked")
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();

        // Hashmap to get the frequency
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // store element to a bucket, frequency is the index
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int index = e.getValue();
            if (bucket[index] == null)
                bucket[index] = new ArrayList<>();
            bucket[index].add(e.getKey());
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = bucket.length - 1; k > 0; i--) {
            if (bucket[i] != null) {
                ret.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }
        return ret;
    }
    
    /*
     * Solution 2: Heap 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        // Important!
        Queue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
        for(int num : map.keySet()){
            heap.add(num);
            if(heap.size() > k) 
                heap.poll();
        }
        
        List<Integer> ret = new ArrayList<>();
        while(!heap.isEmpty())
            ret.add(0, heap.poll());
        
        return ret;
    }
}
