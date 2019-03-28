package hash_table;

import java.util.*;

public class Two_Sum_1 {
    
    /*
     * Solution 1: One-pass Hash Map
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i]))
                return new int[]{map.get(target-nums[i]),i};
            map.put(nums[i],i);
        }
        return null;
    }
    
    
}
