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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        return inorder;
    }
    
    /*private void inorder(TreeNode root, List<Integer> inorder){
        if(root == null) return;
        inorder.add(root.val);
        inorder(root.left, inorder);
        inorder(root.right, inorder);
    }*/
    
    private void inorder(TreeNode root, List<Integer> inorder){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            inorder.add(current.val);
            if(current.right != null) stack.push(current.right);
            if(current.left != null) stack.push(current.left);
        }
    }
}