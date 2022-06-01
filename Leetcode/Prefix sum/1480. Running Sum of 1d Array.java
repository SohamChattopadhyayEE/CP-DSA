/*
Algorithm:
---------------------------------------------------------------------------------------------
1. Simple `Prefix sum` approach has been taken for this problem.
2. Initiate an array of length equal to the input array `nums`.
3. Assing the first element of `nums` to the first element of the `Prefix sum` array.
4. Iterate through the `nums` array from i=0 to i=n-1 with the pointer being increased by 1.
5. Fill the prefix sum array in the following manner:
                      `arr[i] = nums[i] + arr[i-1]`
6. Return the array.
---------------------------------------------------------------------------------------------
*/

class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1; i<n; i++)
            prefixSum[i] = nums[i]+prefixSum[i-1];
        return prefixSum;
    }
}
