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
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        getParents(root, p, list1);
        getParents(root, q, list2);
        int i=1, j=1;
        while(i<list1.size() && j<list2.size() && list1.get(i)==list2.get(j)){
            i++;
            j++;
        }
        return list1.get(i-1);
    }
    public boolean getParents(TreeNode root, TreeNode p, List<TreeNode> list){
        if(root==null){
            return false;
        }
        list.add(root);
        if(root==p){
            return true;
        }
        if(getParents(root.left, p, list) || getParents(root.right, p, list)){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
}