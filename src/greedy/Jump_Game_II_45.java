package greedy;

public class Jump_Game_II_45 {
    public int jump(int[] nums) {
        int jumps = 0;
        int end = 0;   // end of this jumps
        int reach = 0; // farest reach index of this jump
        for(int i = 0; i < nums.length - 1; i++) { // dont need to jump when reach the last index
            reach = Math.max(reach, nums[i] + i);
            if(i == end) { // go to next jump
                jumps++;
                end = reach;
            }
        }
        return jumps;
    }
}
