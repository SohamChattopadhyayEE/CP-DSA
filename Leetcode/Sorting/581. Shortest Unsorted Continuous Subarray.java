/*
Algorithm:
-------------------------------------------------------------
1. Sort the array and store the sorted array into a new 
   array (say `temp`).
2. Start traversing by comparing elements of both the arrays
   to find the left most point from where the unsorted 
   subarray begins.
3. Similarly, find the right most point too.
4. Return the length of the subarray bounded by these points.
-------------------------------------------------------------
*/


class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        Arrays.sort(temp);
        int start = 0;
        for(int i=0; i<n; i++){
            if(nums[i] != temp[i]){
                start = i;
                break;
            }
        }
        int end = 0;
        for(int i=n-1; i>=0; i--){
            if(nums[i] != temp[i]){
                end = i;
                break;
            }
        }
        return end-start <= 0 ? 0 : end-start+1;
    }
}
