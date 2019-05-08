package hash_table;

import java.util.*;

public class Four_Sum_18 {
    
    /* 
     * By using 3Sum
     * Time Complexity: O(N^3) 
     * Space Complexity: O(N^2)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        
        for(int i = 0; i < nums.length-3; i++){
            if (i != 0 && nums[i] == nums[i-1]) continue;
            
            int[] temp = Arrays.copyOfRange(nums, i + 1, nums.length);
            threeSum(ret, nums[i], temp, target - nums[i]);
        }
        
        return ret;
    }

    
    public void threeSum(List<List<Integer>> ret,int first, int[] nums, int target) {
           
        for(int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) {
                    ret.add(Arrays.asList(first, nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
                else if(sum < target) j++;
                else k--;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1,0,-1,0,-2,2};
        int target = 0;
        Four_Sum_18 t = new Four_Sum_18();
        List<List<Integer>> ls = t.fourSum(nums, target);
        for(List<Integer> l : ls) {
            for(Integer num : l) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
