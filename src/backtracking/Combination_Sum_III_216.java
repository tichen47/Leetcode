package backtracking;

import java.util.*;

public class Combination_Sum_III_216 {
    /*
     * Solution: Backtracking
     * Time Complexity: O(9^k)
     * Space Complexity: O(k) 
     */ 
    List<List<Integer>> ret;
    List<Integer> cur;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        ret = new ArrayList<>();
        cur = new ArrayList<>();
        
        helper(k, n, 1);
        return ret;
    }
    
    public void helper(int k, int n, int index){
        if(k == 0){
            if(n == 0) ret.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i = index; i <= 9 && i <= n; i++){
            cur.add(i);
            helper(k-1, n-i, i+1);
            cur.remove(cur.size()-1);
        }
    }
}
