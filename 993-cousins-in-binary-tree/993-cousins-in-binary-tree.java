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
    TreeNode xParent = null, yParent = null;
    int xDepth = -1, yDepth = -2;
    public boolean isCousins(TreeNode root, int x, int y) {
        solve(root, x, y, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }
    
    private void solve(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null) return;
        
        if(root.val == x){
            xDepth = depth;
            xParent = parent;
        } else if(root.val == y){
            yDepth = depth;
            yParent = parent;
        }
        
        solve(root.left, x, y, depth+1, root);
        solve(root.right, x, y, depth+1, root);
        
    }
    
}