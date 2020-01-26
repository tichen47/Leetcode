package array;

public class Non_decreasing_Array_665 {
    public boolean checkPossibility(int[] nums) {
        boolean hasDec = false;
        int pos = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                if(hasDec) return false;
                hasDec = true;
                pos = i + 1;
            }
        }

        return (!hasDec) || pos == 1 || pos == nums.length - 1 || nums[pos - 2] <= nums[pos] || nums[pos - 1] <= nums[pos + 1];
    }
}
