/*
Algorithm:
----------------------------------------------------------------
1. Simple `Backtracking` approach.
2. A pointer is incremented from `0` to the length of the 
   string in each recursion call.
3. When the pointer reaches the length of the input string,
   the modified string is added to the list.
4. In the recursion method, if the pointer indicates a digit,
   then then no operation is performed and the backtracking
   function is called with the index pointer incremented by 1.
5. Otherwise, two cases are to be addressed. One considering
   changing the case of the character indicated by the pointer,
   and other is not altering the character and moving forward 
   with the same. 
6. After the recursion (bactracking) call is over return the
   list.
----------------------------------------------------------------
*/



class Solution {
    int n;
    String s;
    public List<String> letterCasePermutation(String S) {
        s = S;
        n = s.length();
        List<String> res = new ArrayList<>();
        helper("", 0, res);
        return res;
    }
    public void helper(String temp, int idx, List<String> res){
        if(idx == n){
            res.add(temp);
            return;
        }
        char ch = s.charAt(idx);
        if(Character.isDigit(ch))
            helper(temp+ch, idx+1, res);
        else{
            helper(temp+Character.toLowerCase(ch), idx+1, res);
            helper(temp+Character.toUpperCase(ch), idx+1, res);
        }
    }
}
