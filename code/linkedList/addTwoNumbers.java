// https://leetcode.com/problems/add-two-numbers/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        time: O( max(n, m))
        space: O(1) -- excluding output.. output uses O( max(n, m)) space
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        
        int carry = 0;
        ListNode current = result;
        while(l1 != null || l2 != null || carry > 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            
            current.next = new ListNode( (val1 + val2 + carry) % 10);
            carry = (val1 + val2 + carry) / 10;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            
            current = current.next;
        }
        
        return result.next;
    }
}
