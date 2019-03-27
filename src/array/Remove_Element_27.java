package array;

public class Remove_Element_27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null)
            return 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }
}
