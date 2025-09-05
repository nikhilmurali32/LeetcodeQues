/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hset = new HashSet<>();
        if(headA==null || headB==null){
            return null;
        }
        while(headA!=null){
            hset.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(!hset.add(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}