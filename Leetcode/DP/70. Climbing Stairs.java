/*
The problem can be divided into smaller subproblems, i.e for 
ith stair the number of ways it can be reached is the sum of 
(i-1)th stair and (i-2)th stair. 

Algorithm:
1. Make a DP table with size of `n+1`.
2. Let the base condition for 0th and 1st elements be 1.
3. Iterate from 2 to n and iteratively fill the DP table.
4. As mentioned earlier, the logic of filling the DP table is
                dp[i] = dp[i-1]+dp[i-2]
5. Return the nth element of the DP table.
*/

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++)
            dp[i] = dp[i-1]+dp[i-2];
        return dp[n];
    }
}
