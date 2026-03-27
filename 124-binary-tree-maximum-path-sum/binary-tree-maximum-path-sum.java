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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root.left==null && root.right==null){
            return root.val;
        }
        int maxStart = maxPath(root);
        return Math.max(maxSum, maxStart);
    }
    public int maxPath(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            maxSum = Math.max(maxSum, root.val);
            return root.val;
        }
        maxSum = Math.max(maxSum, root.val);
        int leftMax = 0;
        int rightMax = 0;
        if(root.left != null){
            leftMax=Math.max(leftMax, maxPath(root.left));
        }
        if(root.right != null){
            rightMax=Math.max(rightMax, maxPath(root.right));
        }
        maxSum=Math.max(maxSum, leftMax + root.val + rightMax);
        return root.val+Math.max(0, Math.max(leftMax, rightMax));
    }
}