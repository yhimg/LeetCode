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
        /*ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            //if(curr == null) break;
            //next = next.next;
        }*/
        return solve(head, prev);
        //return prev;
    }
    
    private ListNode solve(ListNode head, ListNode prev){
        if(head == null) return prev;
        ListNode temp = head.next;
        head.next = prev;
        return solve(temp, head);
        
    }
}