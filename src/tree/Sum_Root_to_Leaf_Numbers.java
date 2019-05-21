package tree;

public class Sum_Root_to_Leaf_Numbers {
    /*
     * Solution 1: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    public int sumNumbers(TreeNode root, int cur){
        if(root == null) return 0;
        
        cur = cur * 10 + root.val;
        if(root.left == null && root.right == null) return cur;
        return sumNumbers(root.left, cur) + sumNumbers(root.right, cur);
    }
}
