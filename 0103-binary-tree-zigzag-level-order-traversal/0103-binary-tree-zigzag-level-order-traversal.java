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
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        levelOrder(root, levelMap, 1);
        return levelMap.values().stream().collect(Collectors.toList());    
    }

    private void levelOrder(TreeNode node, Map<Integer, List<Integer>> map, int level) {
        if(node == null) return;
        map.putIfAbsent(level, new ArrayList<>());
        if(level%2==0){
            map.get(level).add(0, node.val);
        }else{
            map.get(level).add(node.val);
        }
        levelOrder(node.left, map, level+1);
        levelOrder(node.right, map, level+1);
    }
}