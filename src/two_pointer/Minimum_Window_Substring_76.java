package two_pointer;

import java.util.*;

public class Minimum_Window_Substring_76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray())
            map.put(c, 0);
        for(char c : t.toCharArray()) {
            if(!map.containsKey(c)) return "";
            map.compute(c, (key, val) -> val + 1);
        }

        int start = 0, end = 0, count = t.length();
        int minLen = Integer.MAX_VALUE, minStart = 0;

        while(end < s.length()) {
            char c1 = s.charAt(end);
            if(map.get(c1) > 0) count--;
            map.compute(c1, (key, val) -> val - 1);

            // Contract the window
            while(count == 0) {
                char c2 = s.charAt(start);
                if(minLen > end - start + 1) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                map.compute(c2, (key, val) -> val + 1);
                // Any char not in t can't have value greater than 0
                if(map.get(c2) > 0) count++;

                start++;
            }
            end++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
