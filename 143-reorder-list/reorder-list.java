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
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        reverse(head, slow);
        ListNode temp=head;
        ListNode temp_slow=slow;
        slow=slow.next;
        temp_slow.next=null;
        while(slow!=null){
            ListNode nex=temp.next;
            temp.next=slow;
            ListNode slow_nex=slow.next;
            slow.next=nex;
            slow=slow_nex;
            temp=nex;
        }

    }
    public void reverse(ListNode head, ListNode node){
        ListNode prev=null;
        ListNode curr=node.next;
        while(curr!=null){
            ListNode nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        node.next=prev;
    }
}