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
        ListNode a = new ListNode(0);
        ListNode Current = a;
        int Carry =0;
        while(l1 != null || l2 != null || Carry != 0){
            int sum = Carry;
            if(l1 != null){
                sum +=l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            Carry = sum/10;
            Current.next = new ListNode(sum%10);
            Current = Current.next;
        }
        return a.next;
    }
}