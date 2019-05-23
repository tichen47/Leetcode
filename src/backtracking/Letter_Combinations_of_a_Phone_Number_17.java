package backtracking;

import java.util.*;

public class Letter_Combinations_of_a_Phone_Number_17 {
    /*
     * Solution: Backtracking
     * Time Complexity: O(3^N * 4^M) 
     * Space Complexity: O(3^N * 4 ^M)
     *  N: 2,3,4,5,6,8
     *  M: 7,9
     */  
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if(digits == null || digits.length() == 0) return ret;
        helper(ret, "", 0, digits);
        return ret;
    }
    
    public void helper(List<String> ret, String path, int index, String digits){
        if(index >= digits.length()){
            ret.add(path);
            return;
        }
        String letter = KEYS[digits.charAt(index) - '0'];
        for(int i = 0; i < letter.length(); i++){
            helper(ret, path + letter.charAt(i), index+1, digits);
        }
    }
}
