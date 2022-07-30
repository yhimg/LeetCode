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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isBST(root, null, null);
    }
    
    private boolean isBST(TreeNode root, TreeNode l, TreeNode r){
        if(root == null) return true;
        if(l != null && root.val <= l.val) return false;
        if(r != null && root.val >= r.val) return false;
        return isBST(root.left, l, root) && isBST(root.right, root, r);
        
    }
}