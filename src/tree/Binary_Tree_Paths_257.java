package tree;

import java.util.*;

public class Binary_Tree_Paths_257 {

    /*
     * Solution 1: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if(root == null) return ret;
        
        String cur = "";
        helper(ret, cur, root);
        
        return ret;
    }
    
    public void helper(List<String> ret, String cur, TreeNode root){
        
        if(root.left == null && root.right == null)
            ret.add(cur + root.val);
        
        if(root.left != null) helper(ret, cur + root.val + "->", root.left);
        if(root.right != null) helper(ret, cur + root.val + "->", root.right);
    }
}
