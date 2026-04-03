package Java;
/// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
/// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
/// Constraints:
/// The number of nodes in each linked list is in the range [1, 100].
/// 0 <= Node.val <= 9
/// It is guaranteed that the list represents a number that does not have leading zeros.

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
        int theSum = l1.val + l2.val;
        int carry = theSum / 10;
        int theDigit = theSum % 10;
        ListNode answer = new ListNode(theDigit);
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            theSum = l1.val + l2.val + carry;
            carry = theSum / 10;
            theDigit = theSum % 10;

            answer = new ListNode(theDigit, answer);
            l1 = l1.next;
            l2 = l2.next;
        }

        
        if (l1 != null || l2 != null) {
            ListNode theRest;
            if (l1.next != null) {
                theRest = new ListNode(l1.val, l1.next);
            } else {
                theRest = new ListNode(l2.val, l2.next);
            }
            theSum = theRest.val + carry;
            carry = theSum / 10;
            theDigit = theSum % 10;

            answer = new ListNode(theDigit, answer);
            theRest = theRest.next;
            while (theRest != null) {
                theSum = theRest.val + carry;
                carry = theSum / 10;
                theDigit = theSum % 10;

                answer = new ListNode(theDigit, answer);
                theRest = theRest.next;
            }
        }
        
        if (carry != 0) {
            answer = new ListNode(carry, answer);
        }
        
        // Reverse order because we did it backwards
        ListNode theRealAnswer = new ListNode(answer.val);
        answer = answer.next;
        while (answer != null) {
            theRealAnswer = new ListNode(answer.val, theRealAnswer);
            answer = answer.next;
        }
        return theRealAnswer;
    }
}