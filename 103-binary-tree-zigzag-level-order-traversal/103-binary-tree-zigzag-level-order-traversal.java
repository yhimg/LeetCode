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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode current = null;
        boolean ltr = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i< size; i++){
                current = queue.remove();
                if(ltr){
                    level.add(current.val);
                } else{
                    level.add(0, current.val);
                }
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            result.add(level);
            ltr = !ltr;
        }
        
        
        
        
        /*int level = 0;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        TreeNode current = null;
        List<Integer> mid = new ArrayList<>();
        while(!(s1.empty() && s2.empty())){
            if(level%2==0){
                current = s1.pop();
                mid.add(current.val);
                if(s1.isEmpty()){
                    level++;
                    result.add(mid);
                    mid = new ArrayList<>();
                } 
                if (current.left != null) s2.push(current.left);
                if (current.right != null) s2.push(current.right);
            } else {
                current = s2.pop();
                mid.add(current.val);
                if(s2.isEmpty()){
                    level++;
                    result.add(mid);
                    mid = new ArrayList<>();
                } 
                if (current.right != null) s1.push(current.right);
                if (current.left != null) s1.push(current.left);
            }
        }*/
        return result;
    }
}