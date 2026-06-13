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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return max;
    }
    public int pathSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int sum=root.val;
        int leftMax = pathSum(root.left);
        int rightMax = pathSum(root.right);
        sum += Math.max(0,leftMax)+Math.max(0,rightMax);
        max = Math.max(max, sum);
        return root.val+Math.max(0, Math.max(leftMax, rightMax));
    }
}