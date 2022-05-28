/*
Solution 1: Sorting || Time : O(nlogn), Space : O(1)
*/
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++)
            if(i!=nums[i])
                return i;
        return nums.length;
    }
}

/*
Solution 2: Bit manipulation || Time: O(n), Space: O(1)
*/
class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i=0; i<nums.length; i++)
            res ^= i^nums[i];
        return res;
    }
}
