public class Solution {
    int[][] dirs = {{-2, 1},{2, 1},{-2, -1},{2, -1},{1, -2},{1, 2},{-1, -2},{-1, 2}};
    int m, n;
    public int knight(int A, int B, int C, int D, int E, int F) {
        if(C == E && D == F)
            return 0;
        m=A;
        n=B;
        int a=m*n;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        map.put(C*a+D, 0);
        q.add(C*a+D);
        while(!q.isEmpty()){
            int point = q.poll();
            int xp = point/a;
            int yp = point%a;
            int dist = map.get(point);
            for(int[] dir : dirs){
                int xn = xp+dir[0];
                int yn = yp+dir[1];
                int point_n = xn*a+yn;
                if(xn == E && yn == F)
                    return dist+1;
                if(xn>=0 && xn<m && yn>=0 && yn<n && !map.containsKey(point_n)){
                    q.add(point_n);
                    map.put(point_n, dist+1);
                }
            } 
        }
        return -1;
    }
}
