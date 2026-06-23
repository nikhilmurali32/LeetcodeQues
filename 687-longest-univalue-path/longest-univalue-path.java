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
    public int longestUnivaluePath(TreeNode root) {
        travel(root);
        return max;
    }
    public int travel(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 0;
        }
        int leftVal = travel(root.left);
        int rightVal = travel(root.right);
        if(root.left!=null && root.left.val==root.val){
            leftVal++;
        }
        else{
            leftVal=0;
        }
        if(root.right!=null && root.right.val==root.val){
            rightVal++;
        }
        else{
            rightVal=0;
        }
        max = Math.max(max, leftVal+rightVal);
        return Math.max(leftVal, rightVal);
    }
}