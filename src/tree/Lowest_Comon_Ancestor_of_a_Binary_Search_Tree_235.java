package tree;

public class Lowest_Comon_Ancestor_of_a_Binary_Search_Tree_235 {
    /*
     * Solution 1: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
    
    /*
     * Solution 2: Iterative
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        
        while(true){
            if(p.val < root.val && q.val < root.val)
                root = root.left;
            else if(p.val > root.val && q.val > root.val)
                root = root.right;
            else break;
        }
        return root;
    }
}
