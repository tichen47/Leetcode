package hash_table;

import java.util.*;

public class Valid_Anagram_242 {

    // HashMap
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c))
                return false;
            else if (map.get(c) == 1)
                map.remove(c);
            else
                map.put(c, map.get(c) - 1);
        }
        return map.isEmpty();
    }

    // Array
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] array = new int[128];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)]++;
            array[t.charAt(i)]--;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0)
                return false;
        }
        return true;
    }
}
