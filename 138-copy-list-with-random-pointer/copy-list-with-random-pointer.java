/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        HashMap<Node, Integer> nodeToIndexOrg = new HashMap<>();
        HashMap<Integer, Node> indexToNodeNew = new HashMap<>();


        nodeToIndexOrg.put(head, 0);
        Node prev = new Node(head.val);
        prev.random = head.random;
        Node headB=prev;
        indexToNodeNew.put(0, headB);
        Node tempHeadOrg = head.next;
        int ind=1;
        while(tempHeadOrg != null){
            Node nodeNew = new Node(tempHeadOrg.val);            
            prev.next = nodeNew;
            nodeNew.random = tempHeadOrg.random;
            prev = nodeNew;
            nodeToIndexOrg.put(tempHeadOrg, ind);
            indexToNodeNew.put(ind, nodeNew);
            tempHeadOrg=tempHeadOrg.next;
            ind++;
        }

        Node tempNew = headB;
        while(tempNew != null){
            tempNew.random = indexToNodeNew.get(nodeToIndexOrg.get(tempNew.random));
            tempNew = tempNew.next;
        }
        return headB;
    }
}