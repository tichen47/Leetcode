package array;

public class Rotate_189 {

    /*
     * Solution 1: Brute Force
     * Time Complexity: O(N*k)
     * Space Complexity: O(1)
     */
    public void rotate(int[] nums, int k) {
        int last;
        for(int i = k; i > 0; i--){
            last = nums[nums.length-1];
            for(int j = nums.length-1; j > 0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
    }
    
    /*
     * Solution 2: Extra Array
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public void rotate2(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int index = (i + k)%nums.length;
            temp[index] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = temp[i];
        }
    }
    
    /*
     * Solution 3: Reverse -- Smart Solution
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    public void reverse(int[] nums, int start, int end){
        int temp;
        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    
    /* 
     * Solution 4: Don't understand right now
     * Check on leetcode solution page
     */
    
}
