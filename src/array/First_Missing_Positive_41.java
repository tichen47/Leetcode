package array;

public class First_Missing_Positive_41 {
    
    /*
     * Solution 1:
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        
        // Check if 1 is in the array
        // Convert non-positive number, and number > n to 1
        int numOfOne = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == 1)
                numOfOne++;
            else if(nums[i] < 1 || nums[i] > len)
                nums[i] = 1;
        }
        
        // Return if 1 is not in the array
        if(numOfOne == 0)
            return 1;
        
        // Go through the array
        // If number k is in the array, change nums[k] to negative
        int temp;
        for(int i = 0; i < len; i++){
            temp = Math.abs(nums[i]);
            if(nums[temp-1] > 0)
                nums[temp-1] = - Math.abs(nums[temp-1]);
        }
        
        // Find the first positive index
        for(int i = 0; i < len; i++){
            if(nums[i] > 0)
                return i+1;
        }
        return len+1;
    }
    
    /* 
     * Solution 2: Hashset
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */ 
}
