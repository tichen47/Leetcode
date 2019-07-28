package tree;

import java.util.*;

public class Serialize_and_Deserialize_Binary_Tree_297 {
    /*
     * Solution 1: Recurisve 
     * Time Complexity: O(N) 
     * Space Complexity: O(N)
     */
    
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb){
        if(root == null)
            sb.append("X").append(",");
        else{
            sb.append(root.val).append(",");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }
    
    public TreeNode buildTree(Queue<String> queue) {
        String cur = queue.remove();
        if(!cur.equals("X")){
            TreeNode node = new TreeNode(Integer.valueOf(cur));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
        return null;
    }
}
