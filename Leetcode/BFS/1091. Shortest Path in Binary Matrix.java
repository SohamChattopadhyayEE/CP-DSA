/*
Algorithm:
--------------------------------------------------------------------------------
1. Perform BFS in the input matrix from the starting point (0,0). 
2. Maintain a HashMap to save the information of how far is a point from the 
   source point. 
3. Once a point is visited, change the value of that point from `0` to `1` or
   mark the point as visited. 
4. During the BFS while visiting a valid point in the grid, put that point in
   the map as key and corresponding value is the distance from the source 
   (0,0) which is 1 more than that of the immidiate parent point of the current
   point. 
5. When the BFS call is over, return the value stored in correspondance to the
   final point (n-1, n-1) in the map. 
6. If the map does not contain that point, that is if the point is not visited
   return -1.
--------------------------------------------------------------------------------
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
