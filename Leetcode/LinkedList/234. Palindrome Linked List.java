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
