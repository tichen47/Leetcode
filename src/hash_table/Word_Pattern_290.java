package hash_table;

import java.util.*;

public class Word_Pattern_290 {

    // My Solution
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] array = str.split(" ");
        if (pattern.length() != array.length)
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if ((map.containsKey(c)) && (!map.get(c).equals(array[i])))
                return false;
            else if ((!map.containsKey(c)) && map.containsValue(array[i]))
                return false;
            else
                map.put(c, array[i]);
        }
        return true;
    }

    // Better Solution
    public boolean wordPattern2(String pattern, String str) {
        Map<Object, Integer> map = new HashMap<>();
        String[] array = str.split(" ");
        if (pattern.length() != array.length)
            return false;

        for (Integer i = 0; i < pattern.length(); i++) {
            if (map.put(pattern.charAt(i), i) != map.put(array[i], i))
                return false;
        }
        return true;
    }
}
