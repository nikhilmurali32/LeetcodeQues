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
    int count=0;
    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return count;
    }
    public void helper(TreeNode root, int maxSofar){
        if(root==null){
            return;
        }
        if(root.val>=maxSofar){
            count++;
        }
        int max=Math.max(maxSofar, root.val);
        helper(root.left, max);
        helper(root.right, max);
    }
}