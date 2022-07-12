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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        /*if(root.left == null && root.right == null) return 0;
        
        return 1 + ()*/
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                TreeNode current = q.remove();
                if(current.left == null && current.right == null){
                    return depth;
                }
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }
            depth++;
        }
        return depth;
    }
}