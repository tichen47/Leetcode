package string;

public class Longest_Common_Prefix_14 {

    
    
    /*
     * Solution: Sliding Window
     * Time Complexity: O(N*2)
     * Space Complexity: O(N)
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        String ret = strs[0];
        for(int i = 1; i < strs.length; i++){
            int j = 0;
            for(j = 0; j < Math.min(ret.length(), strs[i].length()); j++){
                if(ret.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ret = ret.substring(0, j);
        }
        return ret;
    }
    
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        
        Longest_Common_Prefix_14 l = new Longest_Common_Prefix_14();
        System.out.println(l.longestCommonPrefix(strs));
    }

}
