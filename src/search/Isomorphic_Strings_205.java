package search;

import java.util.*;

public class Isomorphic_Strings_205 {
    public boolean isIsomorphic(String s, String t) {
        // Assume s and t have same length
        if (s == null)
            return true;
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char l = s.charAt(i);
            char r = t.charAt(i);

            if (map.containsKey(l) && map.get(l) != r)
                return false;
            else if ((!map.containsKey(l)) && map.containsValue(r))
                return false;
            else
                map.put(l, r);

        }
        return true;
    }
}
