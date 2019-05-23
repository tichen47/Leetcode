package backtracking;

import java.util.*;

public class Permutations_46 {
    /*
     * Solution: Recursive
     * Time Complexity: O(N!) 
     * Space Complexity: O(N!)
     */ 
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> numLs = new ArrayList<>();
        for(int num : nums)
            numLs.add(num);
        
        helper(ret, numLs, 0, nums.length);
        return ret;
    }
    
    public void helper(List<List<Integer>> ret, List<Integer> numLs, int index, int len){
        if(index == len - 1){
            ret.add(new ArrayList<Integer>(numLs));
        }
        for(int i = index; i < len; i++){
            Collections.swap(numLs, i, index);
            helper(ret, numLs, index + 1, len);
            Collections.swap(numLs, i, index);
        }    
    }
    
    /*
     * Solution: Iterative
     * Time Complexity: O(N * N!) 
     * Space Complexity: O(N * N!)
     */     
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null || nums.length == 0) return ret;
        List<Integer> path = new ArrayList<>();
        path.add(nums[0]);
        ret.add(path);
        
        for(int i = 1; i < nums.length; i++){
            int value = nums[i];
            List<List<Integer>> newRet = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                for(List<Integer> ls : ret){
                    List<Integer> tempLs = new ArrayList<>(ls);
                    tempLs.add(j, value);
                    newRet.add(tempLs);
                }
            }
            ret = newRet;
        }
        return ret;
    }
}
