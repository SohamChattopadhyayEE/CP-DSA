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
