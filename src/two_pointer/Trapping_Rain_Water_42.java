package two_pointer;

public class Trapping_Rain_Water_42 {
    /*
     * Solution: Brute force
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public int trap(int[] height) {
        int res = 0;
        for(int i = 0; i < height.length; i++) {
            int max_left = 0, max_right = 0;
            for(int j = 0; j < i; j++)
                max_left = Math.max(max_left, height[j]);
            for(int j = height.length - 1; j > i; j--)
                max_right = Math.max(max_right, height[j]);

            int cur = Math.min(max_left, max_right) - height[i];
            res += Math.max(cur, 0);
        }
        return res;
    }

    /*
     * Solution: DP
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int trap2(int[] height) {
        int len = height.length;
        int res = 0;
        if(len == 0) return res;

        int[] left_max = new int[len];
        left_max[0] = height[0];

        for(int i = 1; i < len; i++)
            left_max[i] = Math.max(height[i], left_max[i - 1]);

        int right_max = 0;
        for(int i = len - 1; i >= 0; i--) {
            right_max = Math.max(right_max, height[i]);
            int cur = Math.min(left_max[i], right_max) - height[i];
            res += Math.max(cur, 0);
        }

        return res;
    }

    /*
     * Solution: Two Pointer
     * Time Complexity: O(N) : One pass
     * Space Complexity: O(1)
     */
    public int trap3(int[] height) {
        int res = 0;
        int max_left = 0, max_right = 0;
        int left = 0, right = height.length - 1;
        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] > max_left) max_left = height[left];
                else res += max_left - height[left];
                left++;
            } else {
                if(height[right] > max_right) max_right = height[right];
                else res += max_right - height[right];
                right--;
            }
        }
        return res;
    }
}
