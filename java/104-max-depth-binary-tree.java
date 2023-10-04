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
    public int maxDepthIterative(TreeNode root) {
        Map<TreeNode, Integer> depth = new HashMap<TreeNode, Integer>();

        Queue<TreeNode> stack = new LinkedList<TreeNode>(); 
        if(root == null) {
            return 0;
        }       
        stack.add(root);
        depth.put(root,1);
        int result = 0;
        while(!stack.isEmpty()) {
            TreeNode currNode = stack.poll();
            int currDepth = depth.get(currNode);
            if(currNode.left != null) {
                stack.add(currNode.left);
                depth.put(currNode.left, currDepth+1);
            }
            if(currNode.right != null) {
                stack.add(currNode.right);
                depth.put(currNode.right, currDepth+1);
            }
            result = Math.max(currDepth, result);

        }
        return result;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
