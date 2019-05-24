package backtracking;

import java.util.*;

public class Permutations_II_47 {
    /*
     * Solution: Backtracking
     * Time Complexity: O(N*2^N) 
     * Space Complexity: ???
     */ 
    List<List<Integer>> ret;
    List<Integer> numLs;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        ret = new ArrayList<>();
        numLs = new ArrayList<>();
        Arrays.sort(nums);
        for(int num : nums) numLs.add(num);
        permuteUnique(0, nums.length);
        return ret;
    }
    
    public void permuteUnique(int start, int len){
        if(start == len - 1){
            ret.add(new ArrayList<Integer>(numLs));
            return;
        }
        
        for(int i = start; i < len; i++){
            // Skip duplicate
            if(i > start && numLs.get(i) == numLs.get(i-1)) continue;
            
            // move current number to the start position
            numLs.add(start, numLs.get(i));
            numLs.remove(i+1);    
            
            permuteUnique(start+1, len);
            
            // move current number back to origin position
            numLs.add(i + 1, numLs.get(start));
            numLs.remove(start);
        }
    }
}
