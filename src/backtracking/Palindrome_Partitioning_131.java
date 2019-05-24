package backtracking;

import java.util.*;

public class Palindrome_Partitioning_131 {
    /*
     * Solution: Backtracking
     * Time Complexity: O(N*2^N) 
     * Space Complexity: ???
     */ 
    List<List<String>> ret;
    List<String> cur;
    public List<List<String>> partition(String s) {
        ret = new ArrayList<>();
        cur = new ArrayList<>();
        partition(0, s, s.length());
        return ret;
    }
    
    public void partition(int index, String s, int len) {
        if(index == len){
            ret.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i = index; i < len; i++){
            String tempStr= s.substring(index, i + 1);
            if(palindrome(tempStr)){
                cur.add(cur.size(), tempStr);
                partition(i + 1, s, len);
                cur.remove(cur.size()-1);
            }
        }
    }
    
    public boolean palindrome(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
