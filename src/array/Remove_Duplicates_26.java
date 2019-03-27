package array;

public class Remove_Duplicates_26 {
    
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;

        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[cur]) {
                nums[++cur] = nums[i];
            }
        }
        return ++cur;
    }
}
