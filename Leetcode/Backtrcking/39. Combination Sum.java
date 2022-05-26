class Solution {
    int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(candidates, res, temp, 0, target);
        return res;
    }
    public void backtrack(int[] arr, List<List<Integer>> res, List<Integer> temp, int idx, int t){
        if(t == 0){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=idx; i<n; i++){
            if(t>=arr[i]){
                temp.add(arr[i]);
                t-= arr[i];
                backtrack(arr, res, temp, i, t);
                temp.remove(temp.size()-1);
                t+= arr[i];
            }
            
        }
    }
}
