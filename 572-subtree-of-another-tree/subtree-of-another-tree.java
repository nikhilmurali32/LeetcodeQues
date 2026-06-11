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
 // .3.4.1##.2##.5##
 // .4.1##.2##
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder s1 = new StringBuilder();
        preOrder(root, s1);
        StringBuilder s2 = new StringBuilder();
        preOrder(subRoot, s2);
        if(s2.length()>s1.length()){
            return false;
        }
        String str1 = s1.toString();
        String str2 = s2.toString();
        return str1.contains(str2);
    }
    public void preOrder(TreeNode root, StringBuilder s){
        if(root==null){
            s.append("#");
            return;
        }
        s.append(".");
        s.append(root.val);
        preOrder(root.left, s);
        preOrder(root.right, s);
    }
}