package hash_table;

import java.util.*;

public class Contiguous_Array_525 {
    public int findMaxLength(int[] nums) {
        int max = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if(sum == 0)
                max = Math.max(max, i + 1);
            else if(map.containsKey(sum))
                max = Math.max(max, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return max;
    }

    /*
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * The reason of map.put(0, -1) come out from previous solution
     */
    public int findMaxLength2(int[] nums) {
        int max = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if(map.containsKey(sum))
                max = Math.max(max, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return max;
    }
}
