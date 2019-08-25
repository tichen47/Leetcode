package hash_table;

import java.util.*;

public class Repeated_DNA_Sequences_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for(int i = 0; i < s.length() - 9; i++){
            String cur = s.substring(i, i + 10);
            if(!set.add(cur)) res.add(cur);
        }
        return new ArrayList<>(res);
    }
}
