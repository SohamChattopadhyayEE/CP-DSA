/*
Algorithm:
----------------------------------------------------------------------------------------------------------
1. Find the total absolute distance from each element of the array to the middle element in sorted manner.
2. Sort the array.
3. Find the middle element (`n/2`).
4. Calculte the sum of the distances by iterating through the array.
5. Return the sum.
----------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = nums[n/2];
        int dist = 0;
        for(int num : nums)
            dist += Math.abs(num - mid);
        return dist;
    }
}
