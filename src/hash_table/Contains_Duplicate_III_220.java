package hash_table;

import java.util.*;

public class Contains_Duplicate_III_220 {
    
    /*
     * Sliding Window
     * Time Complexity: O(NlogN) 
     * Space Complexity: O(k)
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k <= 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        int l = 0, r = 0;
        while(r < nums.length - 1){
            if(r - l >= k) { 
                set.remove((long)nums[l++]);
            }
            set.add((long)nums[r++]);
            if(set.ceiling((long)nums[r]-(long)t) != null && set.ceiling((long)nums[r]-(long)t) <= (long)nums[r] + (long)t)  
                return true;
        }
        return false;
    }
}
