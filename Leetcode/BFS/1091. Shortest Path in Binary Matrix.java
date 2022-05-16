/*
Algorithm:
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
*/

class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,-1},{-1,1},{1,1},{-1,-1}};
    int n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        n = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        Queue<Integer> q = new LinkedList<>();
        int a = n*n;
        q.add(0*a+0);
        while(!q.isEmpty()){
            int p = q.poll();
            int x = p/a;
            int y = p%a;
            int d = map.get(p);
            for(int[] dir : dirs){
                int xn = x+dir[0];
                int yn = y+dir[1];
                if(xn>=0 && yn>=0 && xn<n && yn<n && grid[xn][yn] == 0){
                    grid[xn][yn] = 1;
                    int pn = xn*a+yn;
                    map.put(pn, d+1);
                    q.add(pn);
                }
            }
        }
        int pf = (n-1)*a+(n-1);
        return map.containsKey(pf) ? map.get(pf) : -1;
    }
}
