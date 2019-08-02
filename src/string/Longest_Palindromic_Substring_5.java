package string;

public class Longest_Palindromic_Substring_5 {
    /*
     * Solution: Expand Around Center
     * Time Complexity: O(N^2) 
     * Space Complexity: O(1)
     */ 
    public String longestPalindrome(String s) {
        int len = s.length();
        int[] index = new int[2]; // index[0]: start, index[1]: end
        
        for(int i = 0; i < len; i++){
            expandAroundCenter(s, len, i, i, index);
            expandAroundCenter(s, len, i, i+1, index);
        }
        return s.substring(index[0], index[1]);
    }
    
    public void expandAroundCenter(String s, int len, int p, int q, int[] index){
        while(p >= 0 && q < len && s.charAt(p) == s.charAt(q)){
            p--; 
            q++;
        }
        if(q - (p + 1) > index[1] - index[0]){
            index[0] = p + 1;
            index[1] = q;
        }
    }
}
