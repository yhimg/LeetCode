/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null || cloned == null || target == null) 
            return null;
        TreeNode root = cloned;
        TreeNode temp = new TreeNode();
        return solve(root, target.val);
    }
    
    private TreeNode solve(TreeNode root, int val){
        TreeNode result = null;
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode temp = null;
            for(int i=0;i<size; i++){
                temp = q.remove();
                if(temp.val == val){
                    result = temp;
                    break;
                }
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            if(result != null) break;
        }
        return result;
    }
    
    /*private void solve(TreeNode root, int val, TreeNode temp){
        if(root == null) return;
        if(root.val == val){
            temp = new TreeNode(val);
            temp.left = root.left;
            temp.right = root.right;
            return;
        } 
        
        solve(root.left, val, temp);
        solve(root.right, val, temp);
    }*/
}