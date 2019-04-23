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
    
    /*
     * Solution: BFS with two queue  
     * Time Complexity: O(N)?
     * Space Complexity: O(N)?
     */
    public boolean help(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        else if(p == null || q == null || p.val != q.val) return false;
        return help(p.left, q.right) && help(p.right, q.left);
    }
    
    public boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);
        
        while(!q1.isEmpty()){
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            if(!check(t1, t2)) return false;
            
            if(t1 != null){
                
                if(!check(t1.left, t2.right)) return false;
                if(t1.left != null){
                    q1.offer(t1.left);
                    q2.offer(t2.right);
                }
                
                if(!check(t1.right, t2.left)) return false;
                if(t1.right != null){
                    q1.offer(t1.right);
                    q2.offer(t2.left);
                }
            }
        }
        return true;
    }
    
    public boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        else if(p == null || q == null || p.val != q.val) return false;
        return true;
    }
    
    /*
     * Solution: Iterative with one queue
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean isSymmetric3(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode t1 = q.remove();
            TreeNode t2 = q.remove();
            
            if(t1 == null && t2 == null) continue;
            else if(t1 == null || t2 == null || t1.val != t2.val) return false;
            
            q.add(t1.left);
            q.add(t2.right);
            
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
