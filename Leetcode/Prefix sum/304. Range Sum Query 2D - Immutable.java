class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0)
                    sum[i][j] = matrix[i][j];
                else if(i==0 && j>0)
                    sum[i][j] = matrix[i][j]+sum[i][j-1];
                else if(i>0 && j==0)
                    sum[i][j] = matrix[i][j]+sum[i-1][j];
                else
                    sum[i][j] = matrix[i][j]+sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0)
            return sum[row2][col2];
        else if(row1 == 0)
            return sum[row2][col2]-sum[row2][col1-1];
        else if(col1 == 0)
            return sum[row2][col2]-sum[row1-1][col2];
        else
            return sum[row2][col2]-sum[row1-1][col2]-sum[row2][col1-1]+sum[row1-1][col1-1];
    }
}
