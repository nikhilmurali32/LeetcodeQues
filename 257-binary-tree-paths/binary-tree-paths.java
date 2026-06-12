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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        StringBuilder sb = new StringBuilder();
        helper(root, sb, list);
        return list;
    }
    public void helper(TreeNode root, StringBuilder sb, List<String> list){
        int len=sb.length();
        if(root.left==null && root.right==null){
            sb.append(root.val);
            list.add(sb.toString());
            sb.setLength(len);
            return;
        }
        sb.append(root.val).append("->");
        if(root.left!=null){
            helper(root.left, sb, list);
        }
        if(root.right!=null){
            helper(root.right, sb, list);
        }
        sb.setLength(len);
    }
}