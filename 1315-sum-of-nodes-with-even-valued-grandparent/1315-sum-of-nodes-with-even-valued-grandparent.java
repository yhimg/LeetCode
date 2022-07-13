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
    public int sumEvenGrandparent(TreeNode root) {
        return sum(root, null, null);
    }
    
    private int sum(TreeNode root, TreeNode parent, TreeNode grand){
        int sum = 0;
        if(root == null) return 0;
        
        if(grand != null && grand.val%2 == 0){
             sum = root.val;
        }
        sum += sum(root.left, root, parent) + sum(root.right, root, parent);
        
        return sum;
    }
     
}