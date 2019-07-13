package math;

public class Devide_Array_Into_Increasing_Sequences_1121 {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        int max = 1, cur = 1;
        for(int i = 1; i < nums.length; i++){
            cur = nums[i] == nums[i-1] ? cur + 1 : 1;
            max = Math.max(max, cur);
        }
        return (max * K) <= nums.length;
    }
}
