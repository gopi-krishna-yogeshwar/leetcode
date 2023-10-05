class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return validBst(root, null, null);
    }

    public boolean validBst(TreeNode node, Integer left, Integer right) {
        if(node == null) {
            return true;
        }

        if((left != null && node.val <= left) || (right != null && node.val >= right)) return false;
        

        return validBst(node.left, left, node.val) && validBst(node.right, node.val, right);
    }
}
