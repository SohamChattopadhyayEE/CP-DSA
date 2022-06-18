/*
Solution 1 : Time Limit Exceeded
------------------------------------------------------------------------------
Make a string out of the linked list just by traversing through the list and
adding each of the `node.val` in sequential manner to the string. In the later
phase check if the string is palindrome or not. 
------------------------------------------------------------------------------
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
----------------------------------------------------------------------------------
1. Find the middle point using two pointers approach (`fast` and `slow`).
2. When the `fast` pointer reaches to the end then the `slow` pointer reaches
   to the mid point. 
3. When the `slow` pointer reaches to the middle element of the list, reverse
   the list from `slow->next`
4. Initiate another pointer `dummy` at the head of the list.
5. Now using the `dummy` and the `slow` pointers, keep checking if the values of
   the nodes are same. 
6. If 'not same' return `false`, otherwise if the traversal ends and no mismatch
   is found then return `true`.   
----------------------------------------------------------------------------------
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
