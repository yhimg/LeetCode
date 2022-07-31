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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        else if(right == null) return left;
        else return root;*/
        
        if(root == null || root == p || root == q) return root;
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if(root.val > p.val && root.val > q.val)
            return  lowestCommonAncestor(root.left, p, q);
        return root;
        
        /*while(root != null){
            if((root.val < Math.min(q.val, p.val)))
                root = root.right;
            else if((root.val > Math.max(q.val, p.val)))
                root = root.left;
            else return root;
        }
        
        return null;*/
        
        
    }
}