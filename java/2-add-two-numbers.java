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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode result = new ListNode(0);

        ListNode current = result;
        while(l1 != null || l2 != null || carry) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int carryVal = carry ? 1 : 0;

            int value = val1 + val2 + carryVal;
            
            if(value >= 10) {
                carry = true;
                value = value % 10;
            } else {
                carry = false;
            }
            result.next = new ListNode(value);

            if(l1 != null) {
                l1 = l1.next; 
            }
            if(l2 != null) {
                l2 = l2.next;
            }
            
            result = result.next;
        }
        
        return current.next;
        
    }
}
