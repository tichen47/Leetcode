package tree;

public class Diameter_of_BinaryTree_543 {
    int res;
    
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    
    public int helper(TreeNode root){
        if(root == null) return 0;
        int L = helper(root.left);
        int R = helper(root.right);
        res = Math.max(res, L + R);
        return Math.max(L, R) + 1;
    }
}
