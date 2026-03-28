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
        if(root==null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                sb.append("N,");
            }
            else{
                sb.append(node.val).append(",");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String[] vals = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.add(root);
        int i=1;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(!vals[i].equals("N")){
                node.left=new TreeNode(Integer.parseInt(vals[i]));
                q.add(node.left);
            }
            i++;
            if(!vals[i].equals("N")){
                node.right=new TreeNode(Integer.parseInt(vals[i]));
                q.add(node.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));