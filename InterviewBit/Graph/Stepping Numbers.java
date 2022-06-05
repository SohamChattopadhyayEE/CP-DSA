public class Solution {
    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A == 0)
            res.add(0);
        for(int i=1; i<=9; i++){
            dfs(i, A, B, res);
        }
        Collections.sort(res);
        return res;
    }
    public void dfs(int val, int a, int b, ArrayList<Integer> res){
        if(val>b)
            return;
        if(val>=a && val<=b)
            res.add(val);
        int rem = val%10;
        if(rem!=0)
            dfs(val*10+(rem-1), a, b, res);
        if(rem!=9)
            dfs(val*10+(rem+1), a, b, res);
    }
}
