package hash_table;

import java.util.*;

public class Subarray_Sum_Equals_K_560 {
    /*
     * Solution:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // key part
        int ans = 0, sum = 0;
        for(int num : nums) {
            sum += num;
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
