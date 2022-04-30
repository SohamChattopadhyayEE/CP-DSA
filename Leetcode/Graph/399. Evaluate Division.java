class d_val{
    String d;
    double val;
    d_val(String destination, double value){
        this.d = destination;
        this.val = value;
    }
}
class Solution {
    Map<String, List<d_val>> map;
    Set<String> vis;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            List<String> eq = equations.get(i);
            String u = eq.get(0);
            String v = eq.get(1);
            double val = values[i];
            map.putIfAbsent(u, new ArrayList<d_val>());
            map.putIfAbsent(v, new ArrayList<d_val>());
            map.get(u).add(new d_val(v, val));
            map.get(v).add(new d_val(u, 1/val));
        }  
        double[] res = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            String source = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            vis = new HashSet<>();
            if(source.equals(target))
                res[i] = map.containsKey(source) ? 1.00 : -1.00;
            else if(!map.containsKey(source) || !map.containsKey(target))
                res[i] = -1.00;
            else
                res[i] = dfs(source, target, 1.00);
            System.out.println(vis);
        }
        return res;
    }
    public double dfs(String v, String target, double val){
        if(!map.containsKey(v))
            return -1;
        vis.add(v);
        double res = -1.00;
        for(d_val dv : map.get(v)){
            String u = dv.d;
            double vl = dv.val;
            if(u.equals(target))
                return vl;
            double temp = -1.00;
            if(!vis.contains(u))
                temp = dfs(u, target, val*vl);
            if(temp != -1)
                return temp*vl;
        }
        return -1;
    }
}

