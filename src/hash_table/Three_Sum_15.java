package hash_table;

import java.util.*;

public class Three_Sum_15 {
    
    /* 
     * Without HashSet
     * Time Complexity: O(N^2) 
     * Space Complexity: O(N)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums.length <= 2) return ret;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0) break;   // Save time
            else if(i != 0 && nums[i] == nums[i - 1]) continue;   // Skip i with same value
            
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;  // Skip j with same value
                    while(j < k && nums[k] == nums[k+1]) k--;  // Skip k with same value
                }
                else if(sum < 0) j++;
                else k--;
            }
        }
        return ret;
    }
    
    /* 
     * With HashSet, much slower
     * Time Complexity: O(N^2) 
     * Space Complexity: O(N)
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
           
        for(int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if(sum < 0) j++;
                else k--;
            }
        }
        return new ArrayList<>(set);  // Key point: Convert Set to Arraylist
    }
    
    
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        Three_Sum_15 t = new Three_Sum_15();
        List<List<Integer>> ls = t.threeSum(nums);
        for(List<Integer> l : ls) {
            for(Integer num : l) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
