/*
Solution 1: Memoization (Top-Down approach) - 1 ms, 43 mb
Algorithm:
--------------------------------------------------------------------------------
1. Perform DFS from the point (0,0) to find paths to the bottom right corner
   (m-1, n-1).
2. Have a memoization table having size same as that of the matrix,
   as extra space to improve time performance. 
3. During the recursion call, if the DP table contains valid value the directly 
   returns it.
4. Otherwise, the recursion call is performed and the resultant value is stored
   in the DP table. 
--------------------------------------------------------------------------------
*/

class Solution {
    int[][] dirs = {{1,0},{0,1}};
    
    int m,n;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        dp = new int[m][n];
        for(int[] temp : dp)
            Arrays.fill(temp, -1);
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;
        
        return dfs(0, 0, obstacleGrid);
    }
    public int dfs(int x, int y, int[][] mat){
        if(x == m-1 && y == n-1 && mat[x][y] == 0)
            return 1;
        if(dp[x][y] != -1) return dp[x][y];
        int res = 0;
        for(int[] dir : dirs){
            int xn = x+dir[0];
            int yn = y+dir[1];
            if(isValid(xn, yn) && mat[xn][yn] == 0)
                res += dfs(xn, yn, mat);
            
        }
        return dp[x][y] = res;
    }
    public boolean isValid(int x, int y){
        return x>=0 && x<m && y>=0 && y<n;
    }
}

/*
Solution 1: Tabulation (Bottom-Up approach) - 0 ms, 30 mb
Algorithm:
--------------------------------------------------------------------------------
1. Have a DP table with the base condition as if the starting point is an 
   obstacle then (0,0) of the DP table be 0.
2. Iterate through the matrix and if at any point say (x, y), an obstacle is
   found, make value of the DP table at that point be 0.
3. 
--------------------------------------------------------------------------------
*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) 
            return 0;
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else if(i==0){
                    if(j>0) dp[i][j] = dp[i][j-1];
                }
                else if(j==0){
                    if(i>0) dp[i][j] = dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
