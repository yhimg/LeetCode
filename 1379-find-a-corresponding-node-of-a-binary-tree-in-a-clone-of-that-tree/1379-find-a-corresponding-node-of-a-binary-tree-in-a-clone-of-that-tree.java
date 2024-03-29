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
    
    /*private TreeNode solve(TreeNode root, int val){
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
    }*/
    
    private TreeNode solve(TreeNode root, int val){
        if(root == null) return null;
        if(root.val == val) return root;
        TreeNode node = solve(root.left, val);
        if(node != null) return node;
        node = solve(root.right, val);
        return node;
    }
}