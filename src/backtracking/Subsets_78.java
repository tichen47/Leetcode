package backtracking;

import java.util.*;

public class Subsets_78 {
    /*
     * Solution: Backtracking
     * Time Complexity:  O(2^N): total 2^n possible subsets can be there for n items
     * Space Complexity: O(N+N): maximum depth of recursion tree + the list space
     */ 
    List<List<Integer>> ret;
    List<Integer> path;
    
    public List<List<Integer>> subsets(int[] nums) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        
        subsets(nums, 0, nums.length);
        return ret;
    }
    
    public void subsets(int[] nums, int index, int len){
        ret.add(new ArrayList<>(path));
        
        for(int i = index; i < len; i++){
            path.add(nums[i]);
            subsets(nums, i+1, len);
            path.remove(path.size()-1);
        }
    }
}
