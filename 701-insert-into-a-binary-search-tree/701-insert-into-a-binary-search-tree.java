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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = new TreeNode(val);
        if(root == null) return temp;
        TreeNode current = root;
        while(true){ 
            if(current.val >= temp.val){
                if(current.left == null){
                    current.left = temp;
                    break;
                }
                current = current.left;
            }
                
            else {
                if(current.right == null){
                    current.right = temp;
                    break;
                }
                current = current.right;
            }
            
        }
        return root;
    }
    
    /*private TreeNode solve(TreeNode root, TreeNode temp){
        if(root == null) return temp;
        if(root.val < temp.val){
            if(root.right == null){
                root.right = temp; 
                return root;
            } 
            else return solve(root.right, temp);  
        } else {
            if(root.left == null){
                root.left = temp;
                return root;
            } 
            else return solve(root.left, temp);
        }
    }*/
}