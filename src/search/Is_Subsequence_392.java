package search;

public class Is_Subsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(t.length() == 0) return false;
        
        int a = s.length() - 1;
        int b = t.length() - 1;
        
        while(a <= b){
            if(s.charAt(a) == t.charAt(b)){
                if(a == 0) return true;
                a--;
            }
            b--;
        }
        return false;
    }
}
