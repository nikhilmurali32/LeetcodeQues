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
    public ListNode swapNodes(ListNode head, int k) {
        int n=0;
        ListNode temp = head;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        k=Math.min(k, n-k+1);
        int i=1;
        ListNode dummy = new ListNode(0);
        dummy.next=head;

        ListNode prev=dummy;
        ListNode curr=head;

        ListNode leftPrev=dummy;
        ListNode leftCurr=head;
        while(i<=n){
            if(i==k){
                leftPrev=prev;
                leftCurr=curr;
            }
            else if(i==n-k+1){
                if(prev==leftCurr){
                    ListNode currNext=curr.next;
                    leftPrev.next=curr;
                    curr.next=leftCurr;
                    leftCurr.next=currNext;
                    break;
                }
                ListNode leftNext = leftCurr.next;
                prev.next=leftCurr;
                leftCurr.next=curr.next;
                leftPrev.next=curr;
                curr.next=leftNext;
                break;                
            }
            prev=curr;
            curr=curr.next;
            i++;
        }
        return dummy.next;
    }
}