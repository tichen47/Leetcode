package tree;

public class Balanced_Binary_Tree_110 {
    
    /*
     * Solution: Recursive top down 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int l = depth(root.left);
        int r = depth(root.right);
        
        return (Math.abs(l-r) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    
    /*
     * Solution: Recursive botton up 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean isBalanced2(TreeNode root) {
        return help(root) != -1;
    }
    
    public int help(TreeNode root) {
        if(root == null) return 0;
        
        int l = help(root.left);
        int r = help(root.right);
        
        if(l == -1 || r == -1 || Math.abs(l-r) > 1) return -1;
        
        return Math.max(l, r) + 1;
    }
}
