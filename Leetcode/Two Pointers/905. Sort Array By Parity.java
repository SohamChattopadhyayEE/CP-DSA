/*
The problem can be solved with simple `two pointers` approach.
The algorithm for the same is explained below.

Algorithm:
------------------------------------------------------------------
1. Have two pointers pointing to the first and the last 
   elements of the array.
2. Iterate in a while loop with the condition that the pointer 
   pointing to the first elememt (l) is always less than that 
   of the pointer pointing to the last element (r). 
3. While traversing from the first (with l) to the last, skip 
   all those element which are `even`, and while traversing 
   left-ward (with the pointer r) skip all odd elements. 
4. At any point, if the pointer l is stuck at an odd element of 
   the array and the pointer r is at an even element of the same,
   `swap` those values and increment the value of l by one and 
   decrement the value of r also by one.
5. While the traversal is complete, return the modified `nums` 
   array.
------------------------------------------------------------------
*/

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        while(l<r){
            while(l<n && nums[l]%2==0)
                l++;
            while(r>=0 && nums[r]%2==1)
                r--;
            if(l>=r)
                break;
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return nums;
    }
}
