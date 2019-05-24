package backtracking;

import java.util.*;

public class Combination_Sum_39 {
    /*
     * Solution: Backtracking
     * Time Complexity: O(k * 2^N)
     * Space Complexity: O(N) 
     */ 
    List<List<Integer>> ret;
    List<Integer> cur; 
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret = new ArrayList<>();
        cur = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return ret;
    }
    
    public void helper(int[] candidates, int target, int index){
        for(int i = index; i < candidates.length; i++){
            if(target < candidates[i]) break;
            else{
                cur.add(candidates[i]);
                
                if(target == candidates[i])
                    ret.add(new ArrayList<>(cur));
                else
                    helper(candidates, target-candidates[i], i);

                cur.remove(cur.size()-1);
            }
        }
    }
}
