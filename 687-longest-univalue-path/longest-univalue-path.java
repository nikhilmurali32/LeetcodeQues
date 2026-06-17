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
    int gmax=0;
    public int longestUnivaluePath(TreeNode root) {
        findPath(root);
        return gmax;
    }
    public int findPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftMax = findPath(root.left);
        int rightMax = findPath(root.right);

        int leftExt = 0, rightExt=0;

        if(root.left!=null && root.left.val==root.val){
            leftExt = leftMax+1;
        }
        if(root.right!=null && root.right.val==root.val){
            rightExt = rightMax+1;
        }
        gmax = Math.max(gmax, leftExt+rightExt);
        return Math.max(leftExt, rightExt);
    }
}