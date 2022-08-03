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
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        if(len == 0) return null;
        k = k%len;
        temp = head;
        int count = len - k;
        ListNode newHead = null;
        while(temp != null && count > 0){
            count--;
            newHead = temp.next;
            if(count == 0){
                temp.next = null;
                break;
            }
            temp = temp.next;
            
        }
        if(newHead == null) return head;
        temp = newHead;
        while(temp.next != null){
            temp = temp.next;
            
            
        }
        temp.next = head;
        return newHead;
    }
}