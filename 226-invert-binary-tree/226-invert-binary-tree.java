/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        return solve(root);
    }
    
    
    private TreeNode solve(TreeNode root){
        if(root == null) return null;
    
        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);
        
        TreeNode temp = left;
        root.left = right;
        root.right = temp;
        
        return root;
    }
    
}