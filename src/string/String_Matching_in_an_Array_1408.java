package string;

import java.util.*;

public class String_Matching_in_an_Array_1408 {
    public List<String> stringMatching(String[] words) {
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(i == j) continue;
                if(words[j].indexOf(words[i]) != -1) {
                    ret.add(words[i]);
                    break;
                }
            }
        }
        return ret;
    }
}
