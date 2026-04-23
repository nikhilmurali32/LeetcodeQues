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
class Solution {
    ListNode new_head=null;
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        int len=0;
        while(temp != null){
            temp=temp.next;
            len++;
        }
        temp=head;
        ListNode prev=null;
        int skip=0;        
        while(temp!=null){
            if(len-skip < k){
                break;
            }
            reverse(temp, prev, k);
            if(temp==null){
                break;
            }
            prev=temp;
            temp=temp.next;
            skip += k;

        }
        return new_head;
    }
    public void reverse(ListNode node, ListNode prev, int k){
        ListNode prevN=prev;
        ListNode currN=node;
        ListNode prevNode = prev;
        ListNode currNode = node;
        int steps=k;
        while(currNode != null && steps > 0){
            ListNode nextNode=currNode.next;
            currNode.next=prevNode;
            prevNode = currNode;
            currNode=nextNode;
            steps--;
        }
        if(prevN != null){
            prevN.next=prevNode;
        }
        if(prevN == null){
            new_head=prevNode;
        }
        currN.next=currNode;
    }
}