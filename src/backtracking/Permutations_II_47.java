package backtracking;

import java.util.*;

public class Permutations_II_47 {
    /*
     * Solution: Backtracking
     * Time Complexity: O(N*2^N) 
     * Space Complexity: ???
     */ 
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numLs = new ArrayList<>();
        for(int num : nums) numLs.add(num);
        dfs(0, res, numLs, nums.length);
        return res;
    }
    
    public void dfs(int start, List<List<Integer>> res, List<Integer> numLs, int len) {
        if(start == len - 1){
            res.add(new ArrayList<>(numLs));
            return;
        }
        
        for(int i = start; i < len; i++){
            // Skip duplicate
            if(i > start && numLs.get(i) == numLs.get(i-1)) continue;
            
            // move current number to the start position (not swap!)
            numLs.add(start, numLs.get(i));
            numLs.remove(i+1);
            
            dfs(start+1, res, numLs, len);
            
            // move current number back to origin position
            numLs.add(i+1, numLs.get(start));
            numLs.remove(start);
        }
    }
}
