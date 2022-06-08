class Solution {
    public int removePalindromeSub(String s) {
        String sr = reverse(s);
        return sr.equals(s) ? 1 : 2;
    }
    public String reverse(String s){
        String res = "";
        for(int i=s.length()-1; i>=0; i--)
            res += s.charAt(i);
        return res;
    }
}
