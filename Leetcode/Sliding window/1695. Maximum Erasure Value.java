/*
Algorithm:
------------------------------------------------------------------------------------------------------------------------
1. Typical `sliding window` based approach, where two pointers `left` and `right` denotes two extremeties of a subarray
   which satisfies the conditions given and maximum sum of such subarrays are to be found. 
2. To do so, a `HashSet` is maintained which keeps track of the fact that no repeated element is present in the subarray
3. While iterating over the input array, elements are being added to the `set` and to an integer variable holding the 
   `current sum` of the subarray till no repeatation of elements takes place.
4. While repeatation occurs, removing from the `set` as well as substraction from the `current sum` from the `left` is 
   performed.
5. Among all such subarrays which satisfy the given condition of no repeatitive elements, the maximum sum is measured
   and returned after the loop is over. 
------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set = new HashSet<>();
        int currSum=0;
        int max=0;
        for(int l=0, r=0; r<n; r++){
            currSum += nums[r];
            while(l<=r && set.contains(nums[r])){
                currSum -= nums[l];
                set.remove(nums[l++]);
            }
            set.add(nums[r]);
            max = Math.max(max, currSum);
        }
        return max;
    }
}
