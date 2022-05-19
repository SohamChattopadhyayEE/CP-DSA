/*
Algorithm: DFS
---------------------------------------------------------------------------------------------
1. Traverse through the entire matrix.
2. Perform DFS form each of the points of the matrix to find the longest increasing path
   staring from that point.
3. Return the path with maximum length among all the longest paths generated from each point
   of the matrix.
---------------------------------------------------------------------------------------------
*/

class Solution {
    int m, n;
    int[][] mat;
    int[][] dp;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        mat = matrix;
        m = matrix.length;
        n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                max = Math.max(max, dfs(i, j, 1));
            }
        }
        return max;
    }
    public int dfs(int x, int y, int len){
        int res = 0;
        for(int[] dir : dirs){
            int xn = x+dir[0];
            int yn = y+dir[1];
            if(isValid(xn, yn) && mat[xn][yn]>mat[x][y] ){
                int temp = dfs(xn, yn, len+1);
                res = Math.max(res, temp);
            }
        }
        return res+1;
        
    }
    public boolean isValid(int x, int y){
        return x>=0 && x<m && y>=0 && y<n;
    }
}

/*
Algorithm: DP
---------------------------------------------------------------------------------------------
1. Have a memoizatoin table to apply top-down dynamic programming approach.
2. During the DFS call check if the value stored in the dp table of the point at which the 
   recursion call is being carried out, is 0. If it is not then return the value. 
3. Otherwise, perform the recursion call and store the value to the dp table. 
---------------------------------------------------------------------------------------------
*/
class Solution {
    int m, n;
    int[][] mat;
    int[][] dp;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        mat = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                max = Math.max(max, dfs(i, j, 1));
            }
        }
        return max;
    }
    public int dfs(int x, int y, int len){
        if(dp[x][y] != 0)
            return dp[x][y];
        int res = 0;
        for(int[] dir : dirs){
            int xn = x+dir[0];
            int yn = y+dir[1];
            if(isValid(xn, yn) && mat[xn][yn]>mat[x][y] ){
                int temp = dfs(xn, yn, len+1);
                res = Math.max(res, temp);
            }
        }
        return dp[x][y] = res+1;
        
    }
    public boolean isValid(int x, int y){
        return x>=0 && x<m && y>=0 && y<n;
    }
}
