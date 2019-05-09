package hash_table;

import java.util.*;

public class Group_Anagrams_48 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++){
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String sortStr = new String(array);
            
            if(!map.containsKey(sortStr)){
                map.put(sortStr, new ArrayList<String>());
            }
            map.get(sortStr).add(strs[i]);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}
