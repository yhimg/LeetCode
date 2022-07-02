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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        if(root == null) return finalList;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> level = new ArrayList<>();
        while(!queue.isEmpty()){
            if(queue.get(0) == null){
                finalList.add(level);
                queue.remove(0);
                if(queue.isEmpty()){
                    break;
                }
                level = new ArrayList<>();
                System.out.println();
                queue.add(null);
            }
            TreeNode current = queue.remove(0);
            level.add(current.val);
            System.out.print(current.val + " ");
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
        return finalList;
    }
}