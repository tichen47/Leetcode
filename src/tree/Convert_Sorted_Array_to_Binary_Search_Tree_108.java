package tree;

public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {
    /*
     * Solution: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null)
            return null;
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }
}
