package array;

public class Remove_Duplicates_80 {

    /*
     * Solution 1: Two pointer 
     * Time Complexity: O(N)
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int cur_len = 1;
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[cur] != nums[i]) {
                nums[++cur] = nums[i];
                cur_len = 1;
            } else if (cur_len == 1) {
                nums[++cur] = nums[i];
                cur_len++;
            }
        }
        return ++cur;
    }

    /*
     * Solution 2: If more than 2 same value, the third one must equal to the first
     * one if nums[i] == nums[i-2], delete nums[i].
     */
}
