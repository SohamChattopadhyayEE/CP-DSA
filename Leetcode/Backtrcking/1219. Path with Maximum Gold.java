/*
Algorithm:
----------------------------------------------------------------------------------------------------------------------
1. Perform simple `DFS` from each non-zero element of the input matrix.
2. During each the `DFS` call, once a non-zero cell is visited mark it visited by setting the value of it as `0`.
3. Then again perform `DFS` from that point in all four direction where non-zero element exist. 
4. Once that call is over, `backtrack` from there by making the value of that cell again to it's previous value.
5. Each time keep adding the value stored in the cell to the local variable of the DFS algorithm.
6. Keep a `global pointer` to find the max among all.
7. Once `DFS` from all non-zero points of the matrix are over, return the `global pointer` storing the mximum value. 
----------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int m, n;
    int max;
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] != 0)
                    dfs(grid, i, j, grid[i][j]);
            }
        }
        return max;
    }
    public void dfs(int[][] grid, int x, int y, int val){
        max = Math.max(max, val);
        
        int temp = grid[x][y];
        grid[x][y]=0;
        for(int[] dir : dirs){
            int xn = x+dir[0];
            int yn = y+dir[1];
            if(xn>=0 && xn<m && yn>=0 && yn<n && grid[xn][yn] != 0)
                dfs(grid, xn, yn, val+grid[xn][yn]);
            
        }
        grid[x][y] = temp;
    }
}
