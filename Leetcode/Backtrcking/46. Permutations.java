class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<Integer> temp = new ArrayList<>();
        for(int i:nums)
            temp.add(i);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, temp, 0);
        return res;
    }
    public void backtracking(List<List<Integer>> res, List<Integer> temp, int idx){
        if(idx==temp.size())
            res.add(new ArrayList<>(temp));
        for(int i=idx; i<temp.size(); i++){
            swap(idx, i, temp);
            backtracking(res, temp, idx+1);
            swap(idx, i, temp);
        }
    }
    public void swap(int x, int y, List<Integer> temp){
        int temp_int = temp.get(x);
        temp.set(x, temp.get(y));
        temp.set(y, temp_int); 
    }
}
