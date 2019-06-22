package array;

public class Next_Permutation_31 {
    /*
     * Solution: 
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public void nextPermutation(int[] nums) {
        
        // Find first index i breaking descending order
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        
        if(i >= 0){                        // If not entirly descending
            int j = nums.length - 1;       // Start from the rightmost
            while(nums[j] <= nums[i]) j--; // Find the first num greater than nums[i]
            swap(nums, i, j);              // The right part of nums[i] should still be descending
        }
        reverse(nums, i + 1);              // Reverse the right part of nums[i]
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int start){
        int len = nums.length - 1;
        while(start < len)
            swap(nums, start++, len--);
    }
}
