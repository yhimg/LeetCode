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
        bfs(root, result);
        //solve(root, result, 0);
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
    
    private void bfs(TreeNode root, List<Integer> result){
        if(root == null) return;
        Queue<TreeNode> q =new LinkedList();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode temp = null;
            for(int i=0; i< size; i++){
                temp = q.poll();
                if(level == result.size()){
                    result.add(temp.val);
                }
                if(temp.right != null) q.add(temp.right);
                if(temp.left != null) q.add(temp.left);
            }
            level++;
        }
    }
}