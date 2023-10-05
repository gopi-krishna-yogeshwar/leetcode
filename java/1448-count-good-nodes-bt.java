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
    public int goodNodes(TreeNode root) {
        int result = 0;
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(root, Integer.MIN_VALUE);
        queue.add(root);

        while(!queue.isEmpty()){
            root = queue.poll();

            int val = root.val;
            if(root.val >= map.get(root)) {
                result += 1;
            } else {
                val = map.get(root);
            }

            if(root.left != null){
                map.put(root.left, val);
                queue.add(root.left);
            }
            if(root.right != null) {
                 map.put(root.right, val);
                 queue.add(root.right);
            }
        }

        return result;
        
    }
}
