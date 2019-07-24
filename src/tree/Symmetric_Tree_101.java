package tree;

import java.util.*;

public class Symmetric_Tree_101 {
    /*
     * Solution: Recursive 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return help(root.left, root.right);
    }
    
    public boolean help(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        else if(p == null || q == null || p.val != q.val) return false;
        return help(p.left, q.right) && help(p.right, q.left);
    }
   
    /*
     * Solution: Iterative with one queue
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            
            if(p == null && q == null) continue;
            else if(p == null || q == null || q.val != p.val) return false;
            
            queue.offer(p.left);
            queue.offer(q.right);
            
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}
