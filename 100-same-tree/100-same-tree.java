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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*Queue<TreeNode> firstQ = new LinkedList<>();        
        firstQ.add(p);
        firstQ.add(q);
        while(!firstQ.isEmpty()){
            TreeNode first = firstQ.remove();
            TreeNode second = firstQ.remove();
            if(first == null && second == null) continue;
            if(first == null || second == null) return false;
            if(first.val != second.val) return false;
            firstQ.add(first.left);
            firstQ.add(second.left);
            firstQ.add(first.right);
            firstQ.add(second.right);
        }
        return true;*/
        
        
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
        
    }

}