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
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                root = queue.poll();
                
                if(root != null) {
                    if (root.left != null) queue.add(root.left);
                    if(root.right != null) queue.add(root.right);
                }
            }

            result.add(root.val);
        }

        return result;
    }
}
