/*
Algorithm:
---------------------------------------------------------------------
1. Perform `Binary Search` to find any index holding the target
   element.
2. Expand from that index in both rightward and leftward directions
   as long as the elements of the array are equal to the target.
3. Return the right most and the left most positions. 
---------------------------------------------------------------------
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l=0, h=n-1, idx=-1;
        
        // Binary search to find any index holding the target element
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid] == target){
                idx = mid;
                break;
            }else if(nums[mid]<target)
                l = mid+1;
            else 
                h = mid-1;
        }
        int[] res = {-1,-1};
        if(idx == -1)
            return res;
       
        // Expansion in both leftward and rightward directions for end elements 
        l = h = idx;
        while(l>=0 && nums[l] == target)
            l--;
        while(h<n && nums[h] == target)
            h++;
        res[0] = l+1;
        res[1] = h-1;
        return res;
    }
}
