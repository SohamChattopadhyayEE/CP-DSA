/*
Algorithm:
----------------------------------------------------------------------------------------------------
1. Simple `Backtracking` algorithm where each element of the list is considered multiple times 
   till the result equals to the `target` sum. Once that sum is achieved, the `list` is added to 
   the final list.
2. Write a `void` function which fills the resultant list. Each time when a `combination` is being
   created out of the elements of the list, the values of the elements are being substracted from
   the temporary sum of the recursion tree. 
3. Therefore, the base condition is made such that if the current sum of the recursion tree becomes
   `0` then that combination is to be added to the final list.
4. Once filling up the list of combinations is done, it is returned.
----------------------------------------------------------------------------------------------------
*/


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
