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
    int count=0;
    List<TreeNode> op_p = new ArrayList<>();
    List<TreeNode> op_q = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val==p.val && root.val==q.val){
            return root;
        }
        List<TreeNode> op = new ArrayList<>();
        if(root.val==p.val){
            op_p.add(root);
            count++;
        }
        if(root.val==q.val){
            op_q.add(root);
            count++;
        }
        op.add(root);
        dfs(root.left, op, p, q);
        dfs(root.right, op, p, q);
        int i=0;
        while(i<Math.min(op_p.size(), op_q.size()) && op_p.get(i).val==op_q.get(i).val){
            i++;
        }
        return op_p.get(i-1);

    }
    public void dfs(TreeNode node, List<TreeNode> op, TreeNode p, TreeNode q){
        if(node==null || count==2){
            return;
        }
        if(node.val==p.val){
            op_p = new ArrayList<>(op);
            op_p.add(node);
            count++;
        }
        if(node.val==q.val){
            op_q = new ArrayList<>(op);
            op_q.add(node);
            count++;
        }
        if(count==2){
            return;
        }
        
        op.add(node);
        dfs(node.left, op, p, q);
        dfs(node.right, op, p, q);
        op.remove(op.size()-1);
    }
}