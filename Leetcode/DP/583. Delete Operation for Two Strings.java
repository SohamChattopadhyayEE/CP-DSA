class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] lis = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0)
                    lis[i][j] = 0;
                else if(word1.charAt(i-1) == word2.charAt(j-1))
                    lis[i][j] = 1+lis[i-1][j-1];
                else
                    lis[i][j] = Math.max(lis[i-1][j], lis[i][j-1]);
            }
        }
        return m+n-2*lis[m][n];
    }
}
