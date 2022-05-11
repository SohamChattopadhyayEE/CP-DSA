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
