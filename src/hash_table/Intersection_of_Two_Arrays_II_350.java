package hash_table;

import java.util.*;

public class Intersection_of_Two_Arrays_II_350 {
    /* 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int key : nums1){
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);    
            }
            else 
                map.put(key, 1);
        }
        
        for(int key : nums2){
            if(map.containsKey(key) && (map.get(key) > 0)){
                ret.add(key);
                map.put(key, map.get(key) - 1);
            }
        }
        
        int[] retArray = new int[ret.size()];
        for(int i = 0; i < ret.size(); i++){
            retArray[i] = ret.get(i);
        }
        return retArray;
    }
}
