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
        helper(root, new ArrayDeque<>());
        return count;
    }
    public void helper(TreeNode root, Deque<Integer> dq){
        if(root==null){
            return;
        }
        boolean seen=false;
        if(dq.isEmpty() || root.val>=dq.peekLast()){
            dq.addLast(root.val);
            seen=true;
            count++;
        }
        helper(root.left, dq);
        helper(root.right, dq);
        if(seen){
            dq.removeLast();
        }
    }
}