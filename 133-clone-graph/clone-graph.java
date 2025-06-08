/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> hmap = new HashMap<>();
    public Node cloneGraph(Node node) {
        return clone(node);
    }
    public Node clone(Node node){
        if(node==null){
            return null;
        }
        if(hmap.containsKey(node.val)){
            return hmap.get(node.val);
        }
        Node copy = new Node(node.val);
        hmap.put(node.val, copy);
        for(Node nei:node.neighbors){
            copy.neighbors.add(clone(nei));
        }
        return copy;
    }
}