/*
Solution 1 : Time Limit Exceeded
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        String str = "";
        ListNode l = head;
        while(l != null){
            str += String.valueOf(l.val);
            l=l.next;
        }
        int low=0;
        int high=str.length()-1;
        while(low<=high){
            if(str.charAt(low) != str.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}


/*
Solution 2 : Optimized (Accepted)
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, dummy = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next;
        
        while(slow!=null){
            if(dummy.val != slow.val)
                return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
        
    }
    public ListNode reverse(ListNode head){
        ListNode curr = head, prev = null, next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
