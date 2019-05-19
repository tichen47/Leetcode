package tree;

public class Count_Complete_Tree_Nodes_222 {

    /*
     * Solution 1: Recursive 
     * Time Complexity: O(log(N) * log(N)) 
     * Space Complexity: O(log(N))
     */
    public int height(TreeNode root){
        return root == null ? -1 : 1 + height(root.left);
    }
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int h = height(root);
        int h_r = height(root.right);
        
        return h == h_r + 1 ? (1 << h) + countNodes(root.right) : (1 << (h - 1)) + countNodes(root.left);
    }
    
    /*
     * Solution 2: Iterative 
     * Time Complexity: O(log(N) * log(N)) 
     * Space Complexity: O(log(N))
     */ 
    public int countNodes2(TreeNode root) {
        if(root == null) return 0;
        
        int node = 0;
        while(root != null){
            int h = height(root);
            int h_r = height(root.right);
            if(h == h_r + 1){
                node += 1 << h;
                root = root.right;
            }
            else{
                node += 1 << h - 1;
                root = root.left;
            }
        }
        return node;
    }
}
