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
    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }
    public List<TreeNode> generate(int l, int r){
        List<TreeNode> res = new ArrayList<>();
        if(l>r){
            res.add(null);
            return res;
        }
        for(int i=l; i<=r; i++){
            List<TreeNode> left = generate(l, i-1);
            List<TreeNode> right = generate(i+1, r);
            for(TreeNode l_node:left){
                for(TreeNode r_node:right){
                    TreeNode root = new TreeNode(i);
                    root.left=l_node;
                    root.right=r_node;
                    res.add(root);
                }
            }
        }
        return res;
    }
}