package tree;

import java.util.*;

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
    
    /*
     * Solution: Iterative
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */  
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // Map<Child, Parent>
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        
        // Queue for tree traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // Run until find both p and q
        while(!parents.containsKey(p) || !parents.containsKey(q)){
            TreeNode node = queue.poll();
            
            if(node.left != null){
                queue.offer(node.left);
                parents.put(node.left, node);
            }
            if(node.right != null){
                queue.offer(node.right);
                parents.put(node.right, node);
            }
        }
        
        // Set stores all parents for p
        Set<TreeNode> pParents = new HashSet<>();
        while(p != null){
            pParents.add(p);
            p = parents.get(p);
        }
        
        // The first q's ancestor in pParents is the LCA
        while(!pParents.contains(q))
            q = parents.get(q);
        
        return q;
    }
}
