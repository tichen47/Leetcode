package string;

public class Implement_StrStr_28 {

    /*
     * Solution 1: 
     * Time Complexity: O(N * M)
     * Space Complexity: O(M)
     */
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0)
            return 0;
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                for(int j = 0; j < needle.length(); j++){
                    if(haystack.charAt(i + j) != needle.charAt(j))
                        break;
                    else if(j == needle.length() - 1)
                        return i;
                }
            }
        }
        return -1;
    }
 
    
    /*
     * Similar Solution but nicer solution, will be slower
     * Time Complexity: O(N * M)
     * Space Complexity: O(M)
     */
    public int strStr2(String haystack, String needle) {
        for(int i=0; ;i++){
            for(int j=0; ;j++){
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }    
        }    
    }
}
