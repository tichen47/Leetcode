package tree;

import java.util.*;
import javafx.util.Pair;

public class Maximum_Depth_of_Binary_Tree_104 {
    /*
     * Solution: Recursive top to bot 
     * Time Complexity: O(N)
     * Space Complexity: Best O(log2(N)) / Worst O(N)
     */
    public int maxDepth(TreeNode root) {
        return help(root, 0);    
    }
    
    public int help(TreeNode node, int depth){
        if(node == null) return depth;
        depth++;
        return Math.max(help(node.left, depth), help(node.right, depth));
    }
    
    /*
     * Solution: Recursive 2 bot to top
     * Time Complexity: O(N)
     * Space Complexity: Best O(log(N)) / Worst O(N)
     */
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
    /*
     * Solution: Iterative with Pair
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int maxDepth3(TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<TreeNode, Integer>(root,1));
        while(!q.isEmpty()){
            Pair<TreeNode, Integer> temp = q.remove();
            TreeNode node = temp.getKey();
            int curDepth = temp.getValue();
            depth = Math.max(depth, curDepth);
            
            if(node.left != null) q.add(new Pair<TreeNode, Integer>(node.left, curDepth+1));
            if(node.right != null) q.add(new Pair<TreeNode, Integer>(node.right, curDepth+1));
        }
        return depth;
    }
}
