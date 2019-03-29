package sliding_window;

import java.util.*;

public class Length_Of_Longest_Substring_3 {

    /*
     * Solution: Sliding Window
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int l = 0, r = 0, max = 0;
        int len = s.length();

        while (l < len && r < len) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r++));
                max = Math.max(max, r - l);
            } else {
                set.remove(s.charAt(l++));
            }
        }
        return max;
    }
}
