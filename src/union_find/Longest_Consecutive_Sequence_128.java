package union_find;

import java.util.*;

public class Longest_Consecutive_Sequence_128 {
    /*
     * Solution 1:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        for(Integer x : set){
            if(!set.contains(x - 1)) { // key part, restrict each num access once to achieve O(n)
                int y = x + 1;
                while(set.contains(y)) y++;
                res = Math.max(res, y-x);
            }
        }
        return res;
    }
    /*
     * Solution 2:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int longestConsecutive2(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            // Skip duplicate
            if(map.containsKey(num)) continue;

            // Get length of left & right
            int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
            int sum = left + right + 1;
            res = Math.max(res, sum);

            // Update left & right boundary, leave middle data dirty
            map.put(num - left, sum);
            map.put(num + right, sum);
            map.put(num, sum);
        }
        return res;
    }
}
