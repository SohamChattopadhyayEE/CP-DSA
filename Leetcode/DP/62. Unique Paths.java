/*
Algorithm:
--------------------------------------------------------------------------------
1. The `Recursion with memoization` has been applied for this problem. 
2. The idea is if a cell is visited earlier, then return the number of ways
   we can reach to the last cell from the cell `0,0` via that particular cell.
3. If the cell is not visited so far then store the value of the same.
4. For implementing that, we create a `memoization` table (`a 2D matrix`) of
   size `m x n` where the value at `ith` row and `jth` column of the table
   would be holding the number of ways the robot can visit from `0,0` to the
   last cell `m-1, n-1` via cell `i,j`.
5. In this way we can avoid calculating for a particular cell again and again 
   and efficiently deal with the `overlapping sub-problems based` problem. 
--------------------------------------------------------------------------------
*/

class Solution {
    int M, N;
    int[][] dirs = {{0,1},{1,0}};
    public int uniquePaths(int m, int n) {
        M = m;
        N = n;
        int[][] dp = new int[m+1][n+1];
        return dfs(0, 0, dp);
    }
    public int dfs(int x, int y, int[][] dp){
        if(x==M-1 && y==N-1)
            return 1;
        if(dp[x][y] != 0) return dp[x][y];
        int count=0;
        for(int[] dir : dirs){
            int xn = x+dir[0];
            int yn = y+dir[1];
            if(xn<M && yn<N)
                count += dfs(xn, yn, dp);
        }
        return dp[x][y] = count;
    }
}
