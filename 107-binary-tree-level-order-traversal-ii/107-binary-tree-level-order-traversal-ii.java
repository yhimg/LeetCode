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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> mid = new ArrayList();
            int size = q.size();
            TreeNode current = null;
            for(int i=0; i<size; i++){
                current = q.remove();
                mid.add(current.val);
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }
            result.add(mid);
        }
        Collections.reverse(result);
        return result;
    }
}