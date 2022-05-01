class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_val = -float('inf')
        sum_total = 0
        n = len(nums)
        for i in range(n):
            sum_total += nums[i]
            if max_val<sum_total:
                max_val = sum_total
            if sum_total < 0:
                sum_total = 0
        return max_val
