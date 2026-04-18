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
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isBST(TreeNode node, long min, long max){
        if(node==null){
            return true;
        }
        if((long)node.val<=min || (long)node.val>=max){
            return false;
        }
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }
}