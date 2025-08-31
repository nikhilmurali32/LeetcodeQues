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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        helper(root);
        return max;
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left_height=helper(root.left);
        int right_height=helper(root.right);
        max=Math.max(max, left_height + right_height);
        return Math.max(left_height, right_height)+1;        
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right))+1;
    }
}