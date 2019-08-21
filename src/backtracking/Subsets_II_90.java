package backtracking;

import java.util.*;

public class Subsets_II_90 {
    /*
     * Solution: DFS
     * Time Complexity:  O(2^N): total 2^n possible subsets can be there for n items
     * Space Complexity: O(N)
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
    
    /*
     * Solution: BFS
     * Time Complexity:  O(2^N): total 2^n possible subsets can be there for n items
     * Space Complexity: O(N)
     */ 
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        
        int begin = 0; // If the nums[i] equals to nums[i-1], nums[i] will only add to subsets which contain nums[i-1]
                       // res[begin, len) are all the subsets which contains nums[i-1]  
                       // If nums[i] does not equal to nums[i-1], nums[i] will add to all subsets -> begin = 0
        
        for(int i = 0; i < nums.length; i++){
            if(i != 0 && nums[i] != nums[i-1]) begin = 0;
            int len = res.size();
            for(int j = begin; j < len; j++){
                List<Integer> tempLs = new ArrayList<>(res.get(j));
                tempLs.add(nums[i]);
                res.add(tempLs);
            }
            begin = len;
        }
        
        return res;
    }
}
