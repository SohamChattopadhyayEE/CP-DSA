class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        add(res, new ArrayList<Integer>(), nums, nums.length, 0);
        return res;
    }
    public void add(List<List<Integer>> res, List<Integer> temp, int[] nums, int n, int idx){
        if(idx == n){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(nums[idx]);
        add(res, temp, nums, n, idx+1);
        temp.remove(temp.size()-1);
        add(res, temp, nums, n, idx+1);
    }
}
