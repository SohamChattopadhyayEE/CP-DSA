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
