/*
Algorithm:
-----------------------------------------------------------------------------
1. Initiate a DP table of length equal to the input `num`.
2. Set the base condition of 0th element and 1st element of the DP table is 
   0 and 1 respectively.
3. 
-----------------------------------------------------------------------------
*/

class Solution {
    public int numberOfSteps(int num) {
        if(num == 0)
            return 0;
        int[] dp = new int[num+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;  
        dp[1] = 1;
        for(int i=2; i<=num; i++){
            if(i%2 == 0)
                dp[i] = 1+dp[i/2];
            else
                dp[i] = 1+ dp[i-1];
        }
        return dp[num];
    }
}
