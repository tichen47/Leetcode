package backtracking;

import java.util.*;

public class Letter_Combinations_of_a_Phone_Number_17 {
    /*
     * Solution: Backtracking
     * Time Complexity: O(3^N * 4^M) 
     * Space Complexity: O(3^N * 4 ^M)
     * N: 2,3,4,5,6,8
     * M: 7,9
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
    
    /*
     * Solution: Iteration
     * Time Complexity: O(4^N) 
     * Space Complexity: O(4^N)
     */  
    public List<String> letterCombinations2(String digits) {
        String[] board = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> res = new LinkedList<>();
        if(digits.length() == 0) return res;
        
        res.add("");
        for(int i = 0; i < digits.length(); i++){
            int num = digits.charAt(i) - '0';
            String choice = board[num];
            int it = res.size();
            for(int j = 0; j < it; j++){
                String t = res.remove();
                for(int k = 0; k < choice.length(); k++)
                    res.add(t + choice.charAt(k));
            }
        }
        return res;
    }
    
    /*
     * Solution: Simplify of previous solution
     * Time Complexity: O(4^N) 
     * Space Complexity: O(4^N)
     */  
    public List<String> letterCombinations3(String digits) {
        String[] board = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> res = new LinkedList<>();
        int len = digits.length();
        if(len == 0) return res;
        res.add("");
        
        while(res.peek().length() != len){
            String next = res.remove();
            int index = digits.charAt(next.length()) - '0';
            char[] choice = board[index].toCharArray();
            for(char ch : choice)
                res.add(next + ch);
        }
        
        return res;
    }
}
