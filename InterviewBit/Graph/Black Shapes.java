public class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int m, n, a;
    public int black(ArrayList<String> A) {
        int count = 0;
        m = A.size();
        if(m == 0)
            return 0;
        n = A.get(0).length();
        a = m*n;
        for(int i=0; i<A.size(); i++){
            for(int idx=0; idx<A.get(i).length(); idx++){
                if(A.get(i).charAt(idx) == 'X'){
                    dfs(i, idx, A);
                    count++;
                }
                
            }
        }
        return count;
    }
    public void dfs(int x, int y, ArrayList<String> mat){
        mat.set(x, mat.get(x).substring(0, y)+'O'+mat.get(x).substring(y+1));
        for(int[] dir : dirs){
            int xn = x+dir[0];
            int yn = y+dir[1];
            if(xn>=0 && xn<m && yn>=0 && yn<n && mat.get(xn).charAt(yn) == 'X')
                dfs(xn, yn, mat);
        }
    }
}
