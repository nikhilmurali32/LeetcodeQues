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
    public int rob(TreeNode root) {
        return helper(root, new HashMap<>());
    }
    public int helper(TreeNode root, HashMap<TreeNode, Integer> hmap){
        if(root==null){
            return 0;
        }
        if(hmap.containsKey(root)){
            return hmap.get(root);
        }
        int val=0;
        if(root.left!=null){
            val += helper(root.left.left, hmap)+helper(root.left.right, hmap);
        }
        if(root.right!=null){
            val += helper(root.right.left, hmap)+helper(root.right.right, hmap);
        }
        val = Math.max(val+root.val, helper(root.left, hmap)+helper(root.right, hmap));
        hmap.put(root,val);
        return val;
    }
}