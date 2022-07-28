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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        solve(root, result, 0);
        return result;
    }
    
    private void solve(TreeNode root, List<Integer> result, int depth){
        if(root == null) return;
        if(result.size() == depth){
            result.add(root.val);
            
        } 
        solve(root.right, result, depth+1);
        solve(root.left, result, depth+1);
            
        

    }
}