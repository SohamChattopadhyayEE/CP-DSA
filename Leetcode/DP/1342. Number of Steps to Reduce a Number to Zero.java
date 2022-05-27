/*
Algorithm:
-----------------------------------------------------------------------------
1. Initiate a DP table of length equal to the input `num`.
2. Set the base condition of 0th element and 1st element of the DP table is 
   0 and 1 respectively.
3. Iterate from 2 to num with a iterator say `i` in such a way that if i is 
   divisible by 2 then `dp[i] = 1+dp[i/2]`. Otherwise, `dp[i] = 1+dp[i-1]`.
4. Return the last element of the DP table dp[num].
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
