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
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalf = reverse(slow.next);
        slow.next=null;
        ListNode firstHalf = head;
        while(secondHalf!=null){
            ListNode next = firstHalf.next;
            ListNode fastNext = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = next;
            firstHalf = next;
            secondHalf = fastNext;
        }
    }
    public ListNode reverse(ListNode head) {
        ListNode curr=head, prev=null;
        while(curr != null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}