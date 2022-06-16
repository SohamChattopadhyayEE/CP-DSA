class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode prev = null, next = null, curr = head, temp = head;
        int len = 0;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        if(len<k)
            return head;
        int count = 0;
        while(count<k && curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        if(next != null)
            head.next = reverseKGroup(next, k);
        
        return prev;
    }
}
