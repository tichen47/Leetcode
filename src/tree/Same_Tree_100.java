package tree;

import java.util.*;

public class Same_Tree_100 {

    /*
     * Solution: Recursive 
     * Time Complexity: O(N)
     * Space Complexity: Best O(log2(N)) / Worst O(N)
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)  
            return true;
        else if (p == null || q == null || p.val != q.val)
            return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    } 
 
    /*
     * Solution: BFS
     * Time Complexity: O(N)
     * Space Complexity: Best O(log2(N)) / Worst O(N)
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null)  
            return true;
        else if (p == null || q == null || p.val != q.val)
            return false;
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        
        while(!q1.isEmpty()){
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            
            if(!check(t1,t2)) return false;
            if(t1 != null){
                
                if(!check(t1.left, t2.left)) return false;
                if(t1.left != null){
                    q1.offer(t1.left);
                    q2.offer(t2.left);
                }
                
                if(!check(t1.right, t2.right)) return false;
                if(t1.right != null){
                    q1.offer(t1.right);
                    q2.offer(t2.right);
                }
            }
        }
        return true;
    }
    
    public boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null)  
            return true;
        else if (p == null || q == null || p.val != q.val)
            return false;
        return true;
    }
}
