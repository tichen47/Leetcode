package array;

import java.util.*;

public class Three_Sum_Closest_16 {
    /*
     * Solution 1: Two Pointer
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = target < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int gap = Math.abs(target - closest);
        
        for(int i = 0; i < n - 2; i++){
            int j = i + 1, k = n - 1;
            
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int nGap = Math.abs(target - sum);
                
                if(sum == target) return target;
                else if(sum < target) j++;
                else k--;
                
                if(nGap < gap){
                    closest = sum;
                    gap = nGap;
                }
            }
        }
        return closest;
    }
}
