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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if(currNode != null) {
                if(currNode.val == subRoot.val && isSameTree(currNode, subRoot)) {
                    return true;
                }
                queue.add(currNode.left);
                queue.add(currNode.right);

            } else {
                if(currNode == subRoot) {
                    return true;
                }
            }
        }
        return false;
        
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();

        q1.add(p);
        q2.add(q);

        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode c1 = q1.poll();
            TreeNode c2 = q2.poll();

            if(c1 == null && c2 == null) {
                continue;
            } else if(c1 != null && c2 != null) {
                if(c1.val != c2.val) return false;
                q1.add(c1.left);
                q1.add(c1.right);
                q2.add(c2.left);
                q2.add(c2.right);
            } else {
                return false;
            }
        }
        if(!q1.isEmpty() || !q2.isEmpty()) return false;

        return true;
        
    }
}
