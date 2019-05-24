package backtracking;

import java.util.*;

public class Subsets_II_90 {
    /*
     * Solution: Backtracking
     * Time Complexity:  O(2^N): total 2^n possible subsets can be there for n items
     * Space Complexity: O(N+N): maximum depth of recursion tree + the list space
     */ 
    List<List<Integer>> ret;
    List<Integer> path;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, nums.length);
        return ret;
    }
    
    public void subsetsWithDup(int[] nums, int index, int len){
        ret.add(new ArrayList<>(path));
        
        for(int i = index; i < len; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            subsetsWithDup(nums, i+1, len);
            path.remove(path.size()-1);
        }
    }
}
