/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        if(((p.val-root.val)>=0 && (q.val-root.val)<=0) || ((p.val-root.val)<=0 && (q.val-root.val)>=0)){
            return root;
        }
        if(p.val<root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
}