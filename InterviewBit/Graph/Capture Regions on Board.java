public class Solution {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    int m, n, ar;
	public void solve(ArrayList<ArrayList<Character>> a) {
        m = a.size();
        n = a.get(0).size();
        ar = m*n;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    if(a.get(i).get(j) == 'O')
                        bfs(a, i, j);
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(a.get(i).get(j) == 'O'){
                    a.get(i).set(j, 'X');
                }
                else if(a.get(i).get(j) == '1')
                    a.get(i).set(j, 'O');
            }
        }        
	}
    public void bfs(ArrayList<ArrayList<Character>> a, int x, int y){
        a.get(x).set(y, '1');
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x*ar+y);
        vis.add(x*ar+y);
        while(!q.isEmpty()){
            int p = q.poll();
            int x1 = p/ar;
            int y1 = p%ar;
            for(int[] dir : dirs){
                int xn = x1+dir[0];
                int yn = y1+dir[1];
                if(xn>=0 && xn<m && yn>=0 && yn<n && !vis.contains(xn*ar+yn) && a.get(xn).get(yn)== 'O'){
                    vis.add(xn*ar+yn);
                    a.get(xn).set(yn, '1');
                    q.add(xn*ar+yn);
                }
            }
        }
    }
}
