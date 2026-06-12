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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        while(!nodes.isEmpty()){
            int size=nodes.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode currNode = nodes.remove();
                list.add(currNode.val);

                if(currNode.left!=null){
                    nodes.add(currNode.left);
                }
                if(currNode.right!=null){
                    nodes.add(currNode.right);
                }
            }
            res.add(list.get(list.size()-1));
        }
        return res;        
    }
}