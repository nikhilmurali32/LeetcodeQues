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
    HashMap<TreeNode, Integer> hmap = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        int pos=findPos(root, target);
        treeTravel(root, k, hmap.get(root));
        return list;

    }
    public int findPos(TreeNode root, TreeNode target){
        if(root==null){
            return -1;
        }
        if(root==target){
            hmap.put(target, 0);
            return 0;
        }
        int left = findPos(root.left, target);
        if(left>=0){
            hmap.put(root, left+1);
            return left+1;
        }
        int right = findPos(root.right, target);
        if(right>=0){
            hmap.put(root, right+1);
            return right+1;
        }
        return -1;
    }
    public void treeTravel(TreeNode root, int k, int len){
        if(root==null){
            return;
        }
        if(hmap.containsKey(root)){
            len=hmap.get(root);
        }
        if(len==k){
            list.add(root.val);
        }
        treeTravel(root.left, k, len+1);
        treeTravel(root.right, k, len+1);
    }
}