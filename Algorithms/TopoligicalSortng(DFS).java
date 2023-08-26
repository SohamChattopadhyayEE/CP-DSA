class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for(int i=0; i<numCourses; i++) graph[i]=new ArrayList<>();
        for(int[] edge: prerequisites)graph[edge[1]].add(edge[0]);
        boolean[] vis = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<numCourses; i++) {
            if(!vis[i])
                topoSort(i, vis, graph, stack);
        }
        int[] res = new int[numCourses];
        int idx=0;
        Map<Integer,Integer> map = new HashMap<>(); 
        while(!stack.isEmpty()) {
            map.put(stack.peek(),idx);
            res[idx++]=stack.pop();
        }
        for(int i=0; i<numCourses; i++){
            for(int u: graph[i]){
                if(map.get(i)>map.get(u))
                    return new int[0];
            }
        }
        return res; 
    }
    void topoSort(int v, boolean[] vis, List<Integer>[] graph, Stack<Integer> stack){
        vis[v]=true;
        for(int u: graph[v]){
            if(!vis[u])
                topoSort(u, vis, graph, stack);
        }
        stack.push(v);
    }
}
