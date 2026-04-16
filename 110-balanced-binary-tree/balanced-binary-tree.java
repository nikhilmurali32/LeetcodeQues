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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(height(root)==10000){
            return false;
        }
        return true;
    }
    public int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(leftHeight==10000 || rightHeight==10000 || Math.abs(leftHeight - rightHeight) >1){
            return 10000;
        }
        return 1+Math.max(leftHeight, rightHeight);
    }
}