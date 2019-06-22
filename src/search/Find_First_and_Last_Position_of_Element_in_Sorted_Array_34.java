package search;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_34 {
    // Binary Search
    public int[] searchRange(int[] nums, int target) {
        // Find target in nums[i, j]
        if(nums.length < 1) return new int[]{-1, -1};
        
        int len = nums.length;
        int left = 0, right = len - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) break;
            else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        int pos = (left + right) / 2;
        if(nums[pos] != target) return new int[]{-1, -1};
        else{
            int start = pos, end = pos;
            while(start > 0 && nums[start-1] == target) start--;
            while(end < len - 1 && nums[end+1] == target) end++;
            return new int[]{start, end};
        }
    }
}
