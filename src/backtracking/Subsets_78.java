package backtracking;

import java.util.*;

public class Subsets_78 {
    /*
     * Solution: Backtracking
     * Time Complexity:  O(2^N): total 2^n possible subsets can be there for n items
     * Space Complexity: O(N+N): maximum depth of recursion tree + the list space
     */ 
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> cur, int start, int[] nums){
        res.add(new ArrayList<>(cur));
        
        for(int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(res, cur, i + 1, nums);
            cur.remove(cur.size() - 1);
        }
    }
    
}
