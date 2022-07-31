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
    public int sumRootToLeaf(TreeNode root) {
        return solve(root, 0);
    }
    
    private int solve(TreeNode root, int prev){
        int sum = 0;
        if(root == null) return sum;
        prev = (prev << 1) + root.val;
        if(root.left == null && root.right == null) sum +=prev;
        return sum + solve(root.left, prev) + solve(root.right, prev);
    }
}