package array;

public class First_Missing_Positive_41 {

    /*
     * Solution 1: 
     * Time Complexity: O(N) 
     * Space Complexity: O(1)
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        // 1. Check if 1 is in the array
        // 2. Convert negative number or number > length to 1;
        boolean hasOne = false;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1)
                hasOne = true;
            if (nums[i] < 1 || nums[i] > len)
                nums[i] = 1;
        }
        if (!hasOne)
            return 1;

        // 3. For each element k in nums, make nums[k-1] negative
        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }

        // 4. Check for positive index
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0)
                return i + 1;
        }

        return len + 1;
    }

    /*
     * Solution 2: Hashset 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
}
