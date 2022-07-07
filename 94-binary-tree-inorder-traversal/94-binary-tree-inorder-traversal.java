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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrderData = new ArrayList<>();
        //if(root == null) return inOrderData;
        inOrder(root, inOrderData);
        return inOrderData;
    }
    /*private void inOrder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }*/
    
    private void inOrder(TreeNode root, List<Integer> result){
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            } else{
                if(!stack.isEmpty()){
                    TreeNode current = stack.pop();
                    result.add(current.val);
                    root = current.right;
                }else{
                    break;
                } 
            }
        }        
    }
    
}