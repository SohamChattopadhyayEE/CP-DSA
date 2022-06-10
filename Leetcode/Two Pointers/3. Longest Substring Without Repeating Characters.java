/*
Algorithm:
-------------------------------------------------------------------------------------------------------
1. The idea is to slide through the string with a variable window size with the given constraint of 
   having no repeated characters. 
2. Initiate two pointers one pointing at the 0th element of the array and another pointing to the next
   element of the prior pointer.
3. Perform sliding window operation within a while loop in such a way that put characters to the set
   if the set does not have it prior and keep increasing the second pointer. If it contains a key then
   start removing from the first pointer untill it contains the character.
4. Maintain a variable which stores the maximum value of the size of the set.
5. Once the while loop is over return the max pointer.
-------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0)
            return 0;
        int i=0, j=i+1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(i));
        int max = Integer.MIN_VALUE;
        while(j<n){
            char ch = s.charAt(j);
            while(set.contains(ch)){
                max = Math.max(max, set.size());
                set.remove(s.charAt(i++));
            }
            set.add(ch);
            j++;
        }
        return Math.max(max, set.size());
    }
}
