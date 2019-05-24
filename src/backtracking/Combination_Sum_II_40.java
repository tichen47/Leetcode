package backtracking;

import java.util.*;

public class Combination_Sum_II_40 {
    /*
     * Solution: Backtracking
     * Time Complexity: O(k * 2^N)
     * Space Complexity: O(N) 
     */
    List<List<Integer>> ret;
    List<Integer> cur;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ret = new ArrayList<>();
        cur = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return ret;
    }
    
    public void helper(int[] candidates, int target, int index){
        for(int i = index; i < candidates.length; i++){
            // We want to make sure the previous candidate **has not** been add to the current list
            // i > index means candidates[i-1] is not in the current list, so we should not add candidates[i]
            if(i > index && candidates[i] == candidates[i-1]) continue;
            
            if(target < candidates[i]) break;
            else{
                cur.add(candidates[i]);
                if(target == candidates[i])
                    ret.add(new ArrayList<>(cur));
                else
                    helper(candidates, target-candidates[i], i+1);
                cur.remove(cur.size()-1);
            }
        }
    }
}
