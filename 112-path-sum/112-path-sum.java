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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return solve(root, 0, targetSum);
    }
    
    private boolean solve(TreeNode root, int sum, int target){
        if(root == null) return false;
        
        sum += root.val;
        if(root.left == null && root.right == null) return sum == target;
        
        return solve(root.left, sum, target) || solve(root.right, sum, target);
        
        
    }
}