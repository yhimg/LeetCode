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
        if(root == null) {
            return 0;
        }
        prev = (prev << 1) | root.val;
        if(root.left == null && root.right == null) sum +=prev;
        
        return sum + solve(root.left, prev) + solve(root.right, prev);
    }
    
    
    private int binaryToDecimal(int binary){
        int decimal = 0;
        int n = 0;
        if(binary == 0) return 0;
        while(binary > 0){
            int temp = binary % 10;
            decimal += temp * Math.pow(2,n); 
            binary = binary/10;
            n++;
        }
        return decimal;
    }
}