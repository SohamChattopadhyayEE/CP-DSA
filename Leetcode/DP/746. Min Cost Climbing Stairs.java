class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
		
		/* Since we have to cover the entire array by jumping,
		initiate the DP table with n+1 elements. */
        int[] dp = new int[n+1];
		
		/*Base cases*/
        dp[0]=cost[0];
        dp[1]=cost[1];
		
		/* Filling the DP table*/
        for(int i=2; i<n+1; i++){
            if(i!=n)
			
				/* As long as i<n, to reach ith stair we could use either of i-1th 
				or i-2th stair, and minimum of the two would be considered.*/
                dp[i] = cost[i]+Math.min(dp[i-1], dp[i-2]);
				
            else
			
				/* For the last jump there is no cost[i]. Hence, it is eliminated.*/
                dp[i] = Math.min(dp[i-1], dp[i-2]);
        }
        return dp[n];
    }
}
