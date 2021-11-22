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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode less = new ListNode(0);
        ListNode lessP = less;
        ListNode more = new ListNode(0);
        ListNode moreP = more;
        ListNode equalP = head;
        ListNode p = head.next;
        
        while(p != null){
            if(p.val < head.val){
                lessP.next = p;
                lessP = lessP.next;
            }else if(p.val > head.val){
                moreP.next = p;
                moreP = moreP.next;
            }else{
                equalP.next = p;
                equalP = equalP.next;
            }
            p = p.next;
        }
        lessP.next = moreP.next = equalP.next = null;
        
        less.next = sortList(less.next);
        more.next = sortList(more.next);
        lessP = less;
        while(lessP.next!=null)
            lessP = lessP.next;
        
        lessP.next = head;
        equalP.next = more.next;
        
        return less.next;
        
    }
}