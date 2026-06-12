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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        getPaths(root, new ArrayList<>(), 0, res, targetSum);
        return res;
    }
    public void getPaths(TreeNode root, List<Integer> list, int sum, List<List<Integer>> res, int targetSum){
        if(root.left==null && root.right==null){
            list.add(root.val);
            sum += root.val;
            if(sum==targetSum){
                res.add(new ArrayList<>(list));
            }
            list.remove(list.size()-1);
            sum -= root.val;
            return;
        }
        list.add(root.val);
        sum += root.val;
        if(root.left!=null){
            getPaths(root.left, list, sum, res, targetSum);
        }
        if(root.right!=null){
            getPaths(root.right, list, sum, res, targetSum);
        }
        list.remove(list.size()-1);
    }
}