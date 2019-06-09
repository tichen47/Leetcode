package string;

import java.util.*;

public class Occurrences_After_Bigram_5083 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        
        String[] array = text.split(" ");
        for(int i = 0; i < array.length - 2; i++){
            if(array[i].equals(first) && array[i+1].equals(second))
                ans.add(array[i+2]);
        }
        
        String[] ret = new String[ans.size()];
        for(int i = 0; i < ret.length; i++)
            ret[i] = ans.get(i);
        
        return ret;
    }
}
