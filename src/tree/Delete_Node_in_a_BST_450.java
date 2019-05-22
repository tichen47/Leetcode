package tree;

public class Delete_Node_in_a_BST_450 {
    /*
     * Solution: Recursive 
     * Time Complexity: O(log(N)) 
     * Space Complexity: O(N)
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        // delete from the right subtree
        if(root.val < key) root.right = deleteNode(root.right, key);
        // delete from the left subtree
        else if(root.val > key) root.left = deleteNode(root.left, key);
        // delete the current node
        else{
            // delete directly if the node is a leaf
            if(root.left == null && root.right == null)
                root = null;
            // if the node has a right child
            else if(root.right != null){
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // if the node only has a left child
            else{
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        
        return root;
    }
    
    /*
     * Successor: the smallest node greater than root
     * One step right and keep going left
     */ 
    public int successor(TreeNode root){
        root = root.right;
        while(root.left != null) root = root.left;
        return root.val;
    }

    /*
     * Predecessor: the largest node smaller than root
     * One step left and keep going right
     */ 
    public int predecessor(TreeNode root){
        root = root.left;
        while(root.right != null) root = root.right;
        return root.val;
    }
}
