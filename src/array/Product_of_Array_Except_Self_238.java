package array;

public class Product_of_Array_Except_Self_238 {
    /*
     * Solution: Two Array
     * Time Complexity: O(N) : 3N
     * Space Complexity: O(N)
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];

        L[0] = 1;
        for(int i = 1; i < len; i++)
            L[i] = L[i - 1] * nums[i - 1];

        R[len - 1] = 1;
        for(int i = len - 2; i >= 0; i--)
            R[i] = R[i + 1] * nums[i + 1];

        int[] ans = new int[len];
        for(int i = 0; i < len; i++)
            ans[i] = L[i] * R[i];

        return ans;
    }

    /*
     * Solution: Follow up
     * Time Complexity: O(N) : 3N
     * Space Complexity: O(1)
     */
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        ans[0] = 1;
        for(int i = 1; i < len; i++)
            ans[i] = ans[i - 1] * nums[i - 1];

        int right = 1;
        for(int i = len - 2; i >= 0; i--) {
            right *= nums[i + 1];
            ans[i] *= right;
        }

        return ans;
    }
}
