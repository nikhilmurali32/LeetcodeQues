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
            return null;
        }
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        dfs(root, p, pathP);
        dfs(root, q, pathQ);
        int i=0;
        while(i<Math.min(pathP.size(), pathQ.size()) && pathP.get(i).val==pathQ.get(i).val){
            i++;
        }
        return pathP.get(i-1);

    }
    public boolean dfs(TreeNode node, TreeNode k, List<TreeNode> path){
        if(node==null){
            return false;
        }
        path.add(node);
        if(node.val==k.val){
            return true;
        }
        
        if(dfs(node.left, k, path) || dfs(node.right, k, path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}