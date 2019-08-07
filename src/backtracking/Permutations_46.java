package backtracking;

import java.util.*;

public class Permutations_46 {
    /*
     * Solution: Recursive
     * Time Complexity: O(N!) 
     * Space Complexity: O(N!)
     */ 
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for(int num : nums) cur.add(num);
        backtracking(res, cur, 0, nums.length);
        return res;
    }
    
    public void backtracking(List<List<Integer>> res, List<Integer> cur, int start, int len){
        if(start == len - 1)
            res.add(new ArrayList<>(cur));
        
        for(int i = start; i < len; i++){
            Collections.swap(cur, start, i);
            backtracking(res, cur, start+1, len);
            Collections.swap(cur, start, i);            
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
