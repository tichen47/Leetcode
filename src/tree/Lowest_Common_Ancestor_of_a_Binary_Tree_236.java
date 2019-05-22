package tree;

public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {
    /*
     * Solution: Recursive
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */  
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }
}
