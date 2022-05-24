/*
Algorithm:
-----------------------------------------------------------------------------------------------
1. Generate all possible substrings of given length using typical `Backtracking` algorithm.
2. If the substrings are valid then add them to a list.
3. Return the list.
-----------------------------------------------------------------------------------------------
*/


class Solution {
    int m;
    public List<String> generateParenthesis(int n) {
        m = 2*n;
        List<String> res = new ArrayList<>();
        dfs(res, "");
        return res;
    }
    public void dfs(List<String> res, String temp){
        if(temp.length() == m){
            if(isValid(temp))
                res.add(temp);
            return;
        }
        dfs(res, temp+'(');
        dfs(res, temp+')');
    }
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>(); 
        for(char ch : s.toCharArray()){
            if(ch == '(')
                stack.add(ch);
            else{
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
