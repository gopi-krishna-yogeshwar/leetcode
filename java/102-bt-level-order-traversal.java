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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        map.put(root, 0);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr == null) continue;
            int level = map.get(curr);
            if(curr.left != null) {
                map.put(curr.left, level+1);
                queue.add(curr.left);
            }

            if(curr.right != null) {
                map.put(curr.right, level+1);
                queue.add(curr.right);
            }

            if(result.size() == level) {
                List<Integer> newList = new ArrayList<Integer>();
                newList.add(curr.val);
                result.add(newList);
            } else {
                result.get(level).add(curr.val);
            }
            map.remove(curr);
            
        }
        return result;
    }
}
