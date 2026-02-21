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
    public int pseudoPalindromicPaths (TreeNode root) {
        helper(root, new ArrayList<>(), new int[10], 0);
        return count;
    }
    public void helper(TreeNode root, List<Integer> list, int[] freq, int countOdd){
        if(root==null){
            return;
        }
        // list.add(root.val);
        if(freq[root.val]==0){
            countOdd++;
        }
        else if(freq[root.val]%2==0){
            countOdd++;
        }
        else if(freq[root.val]%2!=0){
            countOdd--;
        }
        freq[root.val]++;
        if(root.left!=null){
            helper(root.left, list, freq, countOdd);
        }
        if(root.right!=null){
            helper(root.right, list, freq, countOdd);
        }
        if(root.left==null && root.right==null){
            if(countOdd<=1){
                count++;
            }
        }
        // int lastEle = list.get(list.size()-1);
        freq[root.val]--;
        if(freq[root.val]%2 !=0){
            countOdd--;
        }
        // list.remove(list.size()-1);
    }
}