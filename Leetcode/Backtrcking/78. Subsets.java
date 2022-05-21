/*
Algorithm:
----------------------------------------------------------------------------------------------------------
1. Naive `Backtracking` approach is taken for finding all the combinations.
2. Maintain an indexing pointer to indicate a particular element of the array during the call.
3. The base condition of the Backtracking method is, if the indexing pointer points to the last element of
   the input array, add the list of elements to the resultant list of combination.
4. When the indexing pointer is less than that of the lebgth of the input array, addressing two different
   cases is needed. One of them is not consindering current element for the current subset and moving 
   forward with unitely incrementing the index pointer. The other case is simply considerding the element 
   by adding it to the list responsible for representing the current combination. 
5. Once the recursive backtracking call is over, return the list of all combinations of the input array. 
----------------------------------------------------------------------------------------------------------

*/


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
