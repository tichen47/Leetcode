package backtracking;

import java.util.*;

public class Combination_Sum_III_216 {
    /*
     * Solution: Backtracking
     * Time Complexity: O(9^k)
     * Space Complexity: O(k) 
     */ 
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, n, 1);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> cur, int k, int n, int min){
        if(k == 0){
            if(n == 0) res.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i = min; i <= 9; i++){
            cur.add(i);
            dfs(res, cur, k-1, n-i, i+1);
            cur.remove(cur.size()-1);
        }
    }
}
