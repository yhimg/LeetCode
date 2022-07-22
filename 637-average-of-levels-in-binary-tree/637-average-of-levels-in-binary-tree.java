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
    public List<Double> averageOfLevels(TreeNode root) {
        //return bfs(root);
        
        List<Double> sum = new ArrayList();
        List<Integer> count = new ArrayList();
        List<Double> result = new ArrayList();
        dfs(root, 0, sum, count);
        for(int i = 0; i<sum.size(); i++){
            result.add(sum.get(i)/count.get(i));
        }
        return result;
     }
    
    private List<Double> bfs(TreeNode root){
        List<Double> ans = new ArrayList();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            double sum = 0;
            TreeNode temp = null;
            for(int i=0; i<size; i++){
                temp = q.remove();
                sum += temp.val;
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            ans.add((sum/size));
        }
        return ans;
    }
    
    private void dfs(TreeNode root, int level, List<Double> sum, List<Integer> count){
        if(root == null) return;
        
        if(level < sum.size()){
            sum.set(level, sum.get(level)+root.val);
            count.set(level, count.get(level) + 1);
        } else{
            sum.add(1.0 * root.val);
            count.add(1);
        }
        
        dfs(root.left, level+1, sum, count);
        dfs(root.right, level+1, sum, count);
        
        
    }
}