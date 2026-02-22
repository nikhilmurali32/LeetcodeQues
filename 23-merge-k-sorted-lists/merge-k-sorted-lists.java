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
// class Node{
//     ListNode node;
//     int val;
//     Node(ListNode node, int val){
//         this.node=node;
//         this.val=val;
//     }
// }
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val-b.val));
        for(ListNode node:lists){
            if(node!=null){
                pq.add(node);
            }
        }
        if(pq.isEmpty()){
            return null;
        }
        ListNode tempNode = new ListNode(0);;
        ListNode res=tempNode;
        while(!pq.isEmpty()){
            ListNode temp_node = pq.poll();
            tempNode.next = temp_node;
            if(temp_node.next!=null){
                pq.add(temp_node.next);
            }
            tempNode=tempNode.next;
        }
        return res.next;
    }
}