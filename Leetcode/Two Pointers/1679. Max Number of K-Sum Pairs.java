/*
Simple `Two pointers` appoach.

Algorithm:
------------------------------------------------------------
1. `Sort` the input array nums.
2. Have two pointers one of which pointing to the first 
   (low) and another pointing to the last (high) element 
   of the array.
3. Traverse in a while loop till low is less than high
4. Have a counter before the loof initiated with the value
   0.
5. Within the loop if the sum of the two pointers becomes 
   equal to `k` then increment the value of the counter by
   1.
6. If the sum is less than k, shift the low pointer to the
   next element, i.e increment the value of the pointer
   by one.
7. If the sum is greater than k, shift the high pointer to
   it's previous value in the nums, i.e decrement the value
   of the pointer by one.
8. At the end of the loop, return the value of the counter.
------------------------------------------------------------
*/
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int count = 0;
        while(low<high){
            int temp = nums[low]+nums[high];
            if(temp == k){
                low++;
                high--;
                count++;
            }else if(temp<k){
                low++;
            }else
                high--;
        }
        return count;
    }
}
