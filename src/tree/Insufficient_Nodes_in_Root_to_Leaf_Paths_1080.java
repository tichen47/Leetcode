package tree;

public class Insufficient_Nodes_in_Root_to_Leaf_Paths_1080 {
    // Bad question
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) return null;
        
        return traverse(root, 0, limit);
    }
    
    private TreeNode traverse(TreeNode node, int sum, int limit) {
        if (node == null) return null;
        
        boolean hasChildren = node.left != null || node.right != null;
        
        node.left = traverse(node.left, sum + node.val, limit);
        node.right = traverse(node.right, sum + node.val, limit);
        
        if (node.left == null && node.right == null && (sum + node.val < limit || hasChildren)) {
            return null;
        }
        
        return node;
    }
}
