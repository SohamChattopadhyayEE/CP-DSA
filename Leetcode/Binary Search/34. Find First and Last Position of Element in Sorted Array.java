class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l=0, h=n-1, idx=-1;
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
