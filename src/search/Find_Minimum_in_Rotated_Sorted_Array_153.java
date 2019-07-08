package search;

public class Find_Minimum_in_Rotated_Sorted_Array_153 {
    /*
     * Solution: Binary Search
     * Time Complexity: O(logN)
     * Space Complexity: O(1)
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}
