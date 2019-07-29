package tree;

public class Binary_Tree_Maximum_Path_Sum_124 {
    /*
     * Solution 1: Recurisve 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int lSum = Math.max(helper(root.left), 0);
        int rSum = Math.max(helper(root.right), 0);
        
        res = Math.max(res, lSum + rSum + root.val);
        
        return Math.max(lSum, rSum) + root.val;
    }
}
