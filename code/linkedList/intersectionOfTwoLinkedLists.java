// https://leetcode.com/problems/intersection-of-two-linked-lists/

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
    /*
        time: O( m + n)
        space: O(1)
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( headA == null || headB == null) return null;
        
        int lenA = calcSize(headA);
        int lenB = calcSize(headB);
        
        ListNode longList = lenA < lenB ? headB : headA;
        ListNode shortList = lenA < lenB ? headA : headB;
        int longLen = Math.max(lenA, lenB);
        int shortLen = Math.min(lenA, lenB);
        
        while(longLen-- > shortLen) longList = longList.next;
        
        while(longList != null) {
            if(longList == shortList) return longList;
            
            longList = longList.next;
            shortList = shortList.next;
        }
        
        return null;
    }
    
    private int calcSize(ListNode list) {
        int count = 0;
        while(list != null) {
            list = list.next;
            count++;
        }
        return count;
    }
}
