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
    public ListNode addTwoNumbers(ListNode a, ListNode b){
        ListNode dummy = new ListNode();
        ListNode res = new ListNode();
        dummy.next = res;
        int carry = 0;
        while(a!=null && b!=null){
            int sum = carry + a.val + b.val;
            if(sum>=10){
                carry = 1;
                sum %= 10;
            }else{
                carry = 0;
            }
            res.next = new ListNode(sum);
            res = res.next;
            a=a.next;
            b=b.next;
        }
        while(a!=null){
            int sum = carry + a.val;
            if(sum>=10){
                carry = 1;
                sum %= 10;
            }else{
                carry = 0;
            }
            res.next = new ListNode(sum);
            res = res.next;
            a=a.next;
        }
        while(b!=null){
            int sum = carry + b.val;
            if(sum>=10){
                carry = 1;
                sum %= 10;
            }else{
                carry = 0;
            }
            res.next = new ListNode(sum);
            res = res.next;
            b=b.next;
        }
        if(carry>0)
            res.next = new ListNode(carry);
        return dummy.next.next;
    }
}
