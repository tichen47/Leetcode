package hash_table;

import java.util.*;

public class Contains_Duplicate_II_219 {
   
    /*
     * Sliding Window
     * Time Complexity: O(N) 
     * Space Complexity: O(k)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k <= 0) return false;
        Set<Integer> set = new HashSet<>();
        int l = 0, r = 0;
        while(r < nums.length - 1){
            if(r - l >= k) { 
                set.remove(nums[l++]);
            }
            set.add(nums[r++]);
            if(set.contains(nums[r])) return true;
        }
        return false;
    }
    
    /*
     * Amazing Solution
     * Time Complexity: O(N)
     * Space Complexity: O(k)
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i - k - 1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Contains_Duplicate_II_219 c = new Contains_Duplicate_II_219();
        int[] nums = new int[]{1, 2, 1};
        int k = 0;
        System.out.println(c.containsNearbyDuplicate(nums, k));
    }
}
