/*
Algorithm:
---------------------------------------------------------------------------
1. There are two different types of palindromes which are to be considered
   seperately for calculating all palindromic substrings. These two 
   different types are substrings of `even` lengths and that of `odd`
   lengths.
2. For substrings of `odd` lengths start from 0th element of the array to 
   the end with two pointers say `l` and `r` each expanding towards left 
   and towards right till the boundary is reached. For this case initially
   both of these pointers point to the ith element. 
3. For substring of `even` lengths, also start from the 0th element to
   the end, in such a way that for every element the `l` pointer points to
   the `ith` element and the `r` pointer points to `(i+1)th` point. Here
   also `l` and `r` pointers update there positions outwardly. 
4. Increment the count of palindromic substrings for both of the cases
   by one if the characters pointed by pointers `l` and `r` are same.
5. Return the total count. 
---------------------------------------------------------------------------
*/
class Solution{
    public int countSubstrings(String s) {
        int even = 0;
        int odd = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            int l = i;
            int r = i;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                odd++;
                l--;
                r++;
            }
        }
        for(int i=0; i<n-1; i++){
            int l = i;
            int r = i+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                even++;
                l--;
                r++;
            }
        }
        return even + odd;
    }
}
