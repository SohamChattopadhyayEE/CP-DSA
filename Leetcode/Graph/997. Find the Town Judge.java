/*
SOLUTION 1 :
*/


class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust == null || trust.length == 0)
            return n==1?1:-1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : trust){
            int u = edge[0];
            int v = edge[1];
            map.putIfAbsent(v, new ArrayList<>());
            map.get(v).add(u);
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> lis = new ArrayList<>();
        for(int i : map.keySet()){
            if(map.get(i).size() == n-1)
                lis.add(i);
            set.addAll(map.get(i));
        }
        for(int i : lis)
            if(!set.contains(i))
                return i;
        return -1;
    }
}
