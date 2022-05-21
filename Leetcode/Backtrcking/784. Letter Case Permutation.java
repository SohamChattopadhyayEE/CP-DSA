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
