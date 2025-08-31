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
        max=Math.max(max, helper(root));
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left_height=height(root.left);
        int right_height=height(root.right);
        return left_height+right_height;        
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right))+1;
    }
}