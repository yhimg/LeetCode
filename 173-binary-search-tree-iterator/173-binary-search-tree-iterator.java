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
class BSTIterator {


    Stack<TreeNode> stack = new Stack();
    public BSTIterator(TreeNode root) {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode top = stack.pop();
        pushAll(top.right);
        return top.val; 
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void pushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */