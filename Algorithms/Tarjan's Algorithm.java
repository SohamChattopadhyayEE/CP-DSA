/*
Algorithm for Strongly Connected Components of Graph.
*/


import java.io.*;
import java.util.*;

class GFG {

	static boolean[] vis;
	static int[] low, dfsNum;
	static int time = 0;
	public static void findSCs(Map<Integer, List<Integer>> map, int n){
	    low = new int[n];
	    dfsNum = new int[n];
	    vis = new boolean[n];
	    Arrays.fill(low, -1);
	    Arrays.fill(dfsNum, -1);
	    Stack<Integer> stack = new Stack<Integer>();
	    for(int v=0; v<n; v++)
	        if(dfsNum[v] == -1)
	            dfs(v, stack, map);
	}
	public static void dfs(int v, Stack<Integer> stack, Map<Integer, List<Integer>> map){
	    dfsNum[v] = low[v] = time++;
	    vis[v] = true;
	    stack.push(v);
	    if(map.containsKey(v)){
    	    for(int u : map.get(v)){
    	        if(dfsNum[u] == -1){
    	            dfs(u, stack, map);
    	            low[v] = Math.min(low[v], low[u]);
    	        }else if(vis[u]){
    	            low[v] = Math.min(low[v], dfsNum[u]);
    	        }
    	    }
	    }
	    int w = -1;
	    if(low[v] == dfsNum[v]){
	        while(w != v){
	            w = (int)stack.pop();
	            System.out.print(w + " ");
	            vis[w] = false;
	        }
	        System.out.println();
	    }
	}
	public static void main (String[] args) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int n = 4;
		map.put(0, new ArrayList<Integer>(1));
		map.get(0).add(3);
		map.put(1, new ArrayList<Integer>(2));
		map.put(2, new ArrayList<Integer>(0));
		map.get(2).add(3);
		findSCs(map, n);
	}
}
