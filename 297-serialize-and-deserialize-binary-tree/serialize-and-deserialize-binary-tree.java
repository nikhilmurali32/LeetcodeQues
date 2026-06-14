/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        StringBuilder sb = new StringBuilder();
        if(root==null){
            return sb.toString();
        }
        sb.append(root.val).append(",");
        while(!nodes.isEmpty()){
            int size = nodes.size();
            for(int i=0; i<size; i++){
                TreeNode currNode = nodes.remove();
                if(currNode.left==null){
                    sb.append(".").append(",");
                }
                else{
                    sb.append(currNode.left.val).append(",");
                    nodes.add(currNode.left);
                }
                if(currNode.right==null){
                    sb.append(".").append(",");
                }
                else{
                    sb.append(currNode.right.val).append(",");
                    nodes.add(currNode.right);
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        String[] strArr = data.split(",");
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(strArr[0]));
        nodes.add(root);
        int k=1;
        while(!nodes.isEmpty() && k<strArr.length){
            int size = nodes.size();
            int i=0;
            while(i<size){
                TreeNode currNode = nodes.remove();
                if(!strArr[k].equals(".")){
                    TreeNode node = new TreeNode(Integer.valueOf(strArr[k]));
                    currNode.left = node;
                    nodes.add(node);
                }
                k++;
                if(!strArr[k].equals(".")){
                    TreeNode node = new TreeNode(Integer.valueOf(strArr[k]));
                    currNode.right = node;
                    nodes.add(node);
                }
                k++;
                i++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));