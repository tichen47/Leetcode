package search;

public class Search_in_Rotated_Sorted_Array_II_81 {
    /*
     * Solution: Binary Search
     * Average Time Complexity: O(log(N))
     * Worst Time Complexity: O(N) ex: [1,1,1,1,1,1]
     * Space Complexity: O(1)
     */
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > nums[l]) {
                if(target > nums[mid] || target < nums[l])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            else if(nums[mid] < nums[l]) {
                if(target > nums[mid] && target < nums[l])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            else l++;
        }
        return false;
    }
}
