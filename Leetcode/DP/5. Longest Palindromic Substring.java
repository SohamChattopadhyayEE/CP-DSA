/*
Algorithm:
-------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------
*/

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int l=0;
        for(int g=0; g<n; g++){
            for(int i=0, j=g; j<n; i++, j++){
                if(g==0)
                    dp[i][j] = true;
                else if(g==1){
                    if(s.charAt(i) == s.charAt(j))
                        dp[i][j] = true;
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1])
                        dp[i][j] = true;
                }
                if(dp[i][j])
                    l=g+1;
            }
        }
        for(int i=0, j=l-1; j<n; i++, j++)
            if(dp[i][j])
                return s.substring(i, j+1);
        return "";
    }
}
