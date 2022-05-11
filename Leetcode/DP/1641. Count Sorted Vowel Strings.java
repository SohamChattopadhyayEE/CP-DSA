/*
Algorithm: 
-----------------------------------------------------------------------
1. Have a dp table with 7 rows and `n` number of columns where
   0th row is for `null`, 1-5 are for each of the vowel from
   `a` to `e` and the 6th holds the total number, i.e the sum
   of row 1 to row 5.
2. The intuation is-
        for ith column the number of words being started with
        say jth vowel is the summation of all words of (i-1)th
        column except those who start with vowels which come
        lexicographically before to that of the jth vowel. 
        Therefore, the dynamic relationship we have here is -
   dp[i][j] = dp[i-1][6]-sum(dp[i-1][j-1]+dp[i-1][j-2]+...dp[i-1][0])
   where dp[i-1][6] holds the total number of such words of the 
   (i-1)th column.
3. Return dp[n][6].
   

As a sample example of the DP table where  input n is 5 is shown 
below -
    /----------\
    |vowels / n| ->  0   1   2   3   4   5
    \----------/
    |
    V
    null             0   0   0   0   0   0   
    a                0   1   5   15  35  70
    e                0   1   4   10  20  35
    i                0   1   3   6   10  15
    o                0   1   2   3   4   5
    u                0   1   1   1   1   1
    total            0   5   15  35  70  126
-----------------------------------------------------------------------
*/

class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][7];
        Arrays.fill(dp[1], 1);
        dp[1][0] = dp[1][6] = 0;
        sum(dp[1]);
        for(int i=2; i<=n; i++){
            int temp = 0;
            for(int j=1; j<6; j++){
                temp += dp[i-1][j-1];
                dp[i][j] = dp[i-1][6]-temp;
            }
            sum(dp[i]);
        }
        return dp[n][6];
    }
    public void sum(int[] dp){
        for(int i=1; i<6; i++)
            dp[6] += dp[i];
    }
}
