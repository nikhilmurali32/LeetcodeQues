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
    HashMap<TreeNode, Integer> hmap = new HashMap<>();
    int min=0;
    int max=0;
    public int amountOfTime(TreeNode root, int start) {
        findPos(root, start);
        dfs(root, hmap.get(root));
        return max;
    }
    public int findPos(TreeNode root, int start){
        if(root==null){
            return -1;
        }
        if(root.val==start){
            hmap.put(root, 0);
            return 0;
        }
        int left=findPos(root.left, start);
        if(left>=0){
            hmap.put(root, left+1);
            return left+1;
        }
        int right=findPos(root.right, start);
        if(right>=0){
            hmap.put(root, right+1);
            return right+1;
        }
        return -1;
    }
    public void dfs(TreeNode root, int min){
        if(root==null){
            return;
        }
        if(hmap.containsKey(root)){
            min=hmap.get(root);
        }
        if(min>max){
            max=min;
        }
        dfs(root.left, min+1);
        dfs(root.right, min+1);
    }
}