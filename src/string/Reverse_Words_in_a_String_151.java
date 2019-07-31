package string;

import java.util.*;

public class Reverse_Words_in_a_String_151 {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
    
    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.trim().split(" +");
        for(int i = arr.length - 1; i >= 0; i--){
            sb.append(" " + arr[i]);
        }
        sb.delete(0, 1);
        return sb.toString();
    }
}
