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
    public int maxPathSum(TreeNode root) {
        int[] result = {Integer.MIN_VALUE};
        maxPathSum(root, result);
        return result[0];
    }

    public int maxPathSum(TreeNode node, int[] result) {
        if(node == null) return 0;
        int left = Math.max(0, maxPathSum(node.left, result));
        int right = Math.max(0, maxPathSum(node.right, result));
        result[0] = Math.max(result[0], node.val + left + right);
        return Math.max(left, right) + node.val;
    }
}
