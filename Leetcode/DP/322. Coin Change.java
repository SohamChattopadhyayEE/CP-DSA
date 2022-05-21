/*
Solution 1: Recursion
Algorithm:
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
