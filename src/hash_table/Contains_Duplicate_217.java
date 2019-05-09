package hash_table;

import java.util.*;

public class Contains_Duplicate_217 {
    
    /*
     * HashSet
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
    
    /*
     * Sorting
     * Time Complexity: O(NlogN)
     * Space Complexity: O(1)
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) return true;
        }
        return false;
    }
    
    // Solution 3: Brute force
}
