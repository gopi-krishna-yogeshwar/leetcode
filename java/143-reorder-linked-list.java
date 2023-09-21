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
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println(slow.val);
        ListNode reverseList = reverseList(slow.next);
        slow.next = null;


        ListNode first = head;
        while(reverseList != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = reverseList.next;
            first.next = reverseList;
            reverseList.next = tmp1;
            first = tmp1;
            reverseList = tmp2;
        }
        
    }

    public ListNode reverseList(ListNode head) {

        ListNode previous= null;
        ListNode current = head;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;

    }
}
