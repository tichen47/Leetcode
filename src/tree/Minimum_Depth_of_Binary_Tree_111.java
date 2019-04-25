package tree;

import javafx.util.Pair;
import java.util.*;

public class Minimum_Depth_of_Binary_Tree_111 {
    /*
     * Solution: Recursive top down 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left == null && root.right == null) return 1;
        else if(root.left == null) return minDepth(root.right) + 1;
        else if(root.right == null) return minDepth(root.left) + 1;
        else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    
    /*
     * Solution: Iterative BFS 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<TreeNode, Integer>(root,1));
        int min = Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            Pair<TreeNode, Integer> temp = q.remove();
            TreeNode node = temp.getKey();
            int cur = temp.getValue();
            
            if(node == null) continue;
            else if(node.left == null && node.right == null)
                min = Math.min(min, cur);
            else{
                q.add(new Pair<TreeNode, Integer>(node.left, cur+1));
                q.add(new Pair<TreeNode, Integer>(node.right, cur+1));
            }
        }
        return min;
    }
    
    /*
     * Solution: Iterative BFS, optimize previous solution
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int minDepth3(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<TreeNode, Integer>(root,1));
        int cur = 1;
        
        while(!q.isEmpty()){
            Pair<TreeNode, Integer> temp = q.remove();
            TreeNode node = temp.getKey();
            cur = temp.getValue();
            
            if(node == null) continue;
            else if(node.left == null && node.right == null) break;
            else{
                q.add(new Pair<TreeNode, Integer>(node.left, cur+1));
                q.add(new Pair<TreeNode, Integer>(node.right, cur+1));
            }
        }
        return cur;
    }
}
