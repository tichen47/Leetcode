package tree;

import java.util.*;

public class Binary_Tree_Level_Order_Traversal_102 {
    
    /*
     * Solution 1: BFS with queue 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            List<Integer> cur = new ArrayList<>();
            
            int len = q.size();
            for(int i = 0; i < len; i++){
                TreeNode node = q.poll();
                cur.add(node.val);
                
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            
            res.add(cur);
        }        
        return res;
    }
    
    /*
     * Solution 2: Recursive 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    List<List<Integer>> res;
    
    public List<List<Integer>> levelOrder2(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) return res;
        helper(root, 0);
        return res;
    }
    
    public void helper(TreeNode root, int level){
        if(level == res.size()) 
            res.add(new ArrayList<Integer>());
        
        res.get(level).add(root.val);
        if(root.left != null) helper(root.left, level+1);
        if(root.right != null) helper(root.right, level+1);
    }
}
