/*
This is a simple DFS implementation. The algorithm has been explained below.

Algorithm:
-------------------------------------------------------------------------------------
1. Construct a bi-directional graph from the given array of edges.
2. Perform DFS from the given `source`.
3. Maintain a `visited` array to keep a track of visited nodes.
4. Return `True` and get out of the recursion call once target is reached. If target
   is not reached and all possible nodes which can be gone from the `source` node
   are visited return `False`.
-------------------------------------------------------------------------------------
*/

class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> vis;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        map = new HashMap<>();
        for(int[] edge : edges){
            int u=edge[0];
            int v=edge[1];
            map.putIfAbsent(u, new ArrayList<Integer>());
            map.putIfAbsent(v, new ArrayList<Integer>());
            map.get(v).add(u);
            map.get(u).add(v);
        }
        vis = new HashSet<Integer>();
        return dfs(source, destination);
    }
    public boolean dfs(int u, int target){
        if(u == target)
            return true;
        vis.add(u);
        for(int v : map.get(u)){
            if(!vis.contains(v) && dfs(v, target))
                return true;
        }
        return false;
    }
}
