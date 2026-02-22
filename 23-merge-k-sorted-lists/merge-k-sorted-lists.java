/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Node{
    ListNode node;
    int val;
    Node(ListNode node, int val){
        this.node=node;
        this.val=val;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (a.val-b.val));
        for(ListNode node:lists){
            ListNode tempN=node;
            while(tempN != null){
                pq.add(new Node(tempN, tempN.val));
                tempN=tempN.next;
            }
        }
        if(pq.isEmpty()){
            return null;
        }
        ListNode tempNode = pq.poll().node;
        ListNode res=tempNode;
        while(!pq.isEmpty()){
            Node temp_node = pq.poll();
            tempNode.next = temp_node.node;
            temp_node.node.next=null;
            tempNode=tempNode.next;
        }
        return res;
    }
}