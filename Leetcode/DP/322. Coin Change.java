/*
Solution 1: Recursion - TLE (Time Limit Exceeded)
Algorithm:
----------------------------------------------------------------------------
----------------------------------------------------------------------------
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = recursion(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public int recursion(int[] coins, int n, int number){
        if(n == 0)
            return number;
        if(n<0)
            return Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++)
            res = Math.min(res, recursion(coins, n-coins[i], number+1));
        
        return res;
    }
}

/*
Solution 2: Dynamic Programming (Recursion with Memoization) - Accepted (30 ms, 35 mb)
Algorithm:
----------------------------------------------------------------------------
----------------------------------------------------------------------------
*/



class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        int res = recursion(coins, amount, 0, dp);
        return res == Integer.MAX_VALUE  ? -1 : res;
    }
    public int recursion(int[] coins, int n, int number, int[] dp){
        if(n == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int temp = 0;
            if(n-coins[i]>=0){
                if(dp[n-coins[i]] != -1)
                    temp = dp[n-coins[i]];
                else
                    temp = recursion(coins, n-coins[i], number+1, dp);
                if(temp != Integer.MAX_VALUE)
                    res = Math.min(res, temp+1);
            }
            
        }
        
        return dp[n] = res;
    }
}

/*
Solution 3: Dynamic Programming (Tabulation) - Accepted (20 ms, 32 mb)
Algorithm:
----------------------------------------------------------------------------
----------------------------------------------------------------------------
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if(i-coins[j] >=0 && dp[i-coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
