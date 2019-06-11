package string;

public class Longest_Palindromic_Substring_5 {
    /*
     * Solution: Expand Around Center
     * Time Complexity: O(N^2) 
     * Space Complexity: O(1)
     */ 
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }            
        }
        return s.substring(start, end+1);
    }
               
    private int expandAroundCenter(String s, int left, int right){
        int l = left, r = right;
        while(l >= 0 && r < s.length()){
            if(s.charAt(l) != s.charAt(r)) break;
            l--;
            r++;
        }
        return r - l - 1;
    }
}
