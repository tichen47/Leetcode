package two_pointer;

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
    
    /*
     * Solution: Sliding Window with map
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0, j = 0; j < n; j++){
            char ch = s.charAt(j);
            if(map.containsKey(ch))
                i = Math.max(i, map.get(ch) + 1);   // Math.max used for: "abba"
            ans = Math.max(ans, j - i + 1);
            map.put(ch, j);
        }
        return ans;
    }
}
