class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int l=0;
        // The gap(g) goes from 0 to length-1. 
        for(int g=0; g<n; g++){
            for(int i=0, j=g; j<n; i++, j++){
                // gap 0 means same string containing single character which is inherently palindrome 
                if(g==0)
                    dp[i][j] = true;
                
                // gap 1 is also a trivial condition where only string of two characters are taken into account. 
                else if(g==1){
                    if(s.charAt(i) == s.charAt(j))
                        dp[i][j] = true;
                }
                
                /* when gap is more than 1, the substring would be palindrome iff end characters are same and
                substring in between is also a palindrome.*/
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1])
                        dp[i][j] = true;
                }
                if(dp[i][j])
                    // l holds the length of longest palindrome
                    l=g+1;
            }
        }
        
        // return the substring of longest palindrome
        for(int i=0, j=l-1; j<n; i++, j++)
            if(dp[i][j])
                return s.substring(i, j+1);
        return "";
    }
}
