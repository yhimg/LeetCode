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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            //if(curr == null) break;
            //next = next.next;
        }
        return prev;
    }
    
    private void solve(ListNode head, ListNode newHead){
        if(head == null) return;
        solve(head.next, newHead);
        newHead = new ListNode(head.val);
        newHead = newHead.next;
    }
}