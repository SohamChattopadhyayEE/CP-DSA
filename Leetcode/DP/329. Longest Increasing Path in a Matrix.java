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
        boolean isEnd = true;
        for(int[] dir : dirs){
            int xn = x+dir[0];
            int yn = y+dir[1];
            if(isValid(xn, yn) && mat[xn][yn]>mat[x][y])
                isEnd = isEnd && false;
            else
                isEnd = isEnd && true;
        }
        if(isEnd){
            return len;
        }
        
        for(int[] dir : dirs){
            int xn = x+dir[0];
            int yn = y+dir[1];
            if(isValid(xn, yn) && mat[xn][yn]>mat[x][y] ){
                int temp = dfs(xn, yn, len+1);
                res = Math.max(res, temp);
            }
        }
        return res;
        
    }
    public boolean isValid(int x, int y){
        return x>=0 && x<m && y>=0 && y<n;
    }
}
