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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> leftQ = new LinkedList();
        Queue<TreeNode> rightQ = new LinkedList();
        if(root.left != null) leftQ.add(root.left);
        if(root.right != null) rightQ.add(root.right);
        while(!(leftQ.isEmpty() || rightQ.isEmpty())){
            int sizeL = leftQ.size();
            TreeNode left = null;
            TreeNode right = null;
            for(int i=0; i<sizeL; i++){
                left = leftQ.remove();
                right = rightQ.remove();
                if(left.val != right.val) return false;
                if(left.left != null) leftQ.add(left.left);
                if(right.left != null) leftQ.add(right.left);
                if(right.right != null) rightQ.add(right.right);
                if(left.right != null) rightQ.add(left.right);
            }
            if(leftQ.size() != rightQ.size()) break;;
        }
        if(leftQ.size() != rightQ.size()) return false;
        return true;
        
    }
    
    
}