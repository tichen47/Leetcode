package array;

public class Container_With_Most_Water_11 {
    /*
     * Two Pointer
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            
            int cur = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, cur);
            
            if(height[left] < height[right]){
                int curLeft = height[left];
                while(left < right && height[left] <= curLeft) left++;
            }
            else{
                int curRight = height[right];
                while(left < right && height[right] <= curRight) right--;
            }
        }
        return max;
    }
}
