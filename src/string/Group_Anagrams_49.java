package string;

import java.util.*;

public class Group_Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            
            if(!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            
            map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}
