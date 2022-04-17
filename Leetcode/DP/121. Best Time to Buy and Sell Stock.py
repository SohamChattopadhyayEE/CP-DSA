class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n=len(prices)
        
        '''Prepare an array of length same as that of prices, ith element of which is 
        the maximum element positioned at the right of ith element of the array prices'''
        rightMax = [0]*n
        m=prices[n-1]
        for i in range(n-2, -1, -1):
            if prices[i]>=m:
                rightMax[i]=0
                m=prices[i]
            else:
                rightMax[i]=m
        
        '''Find the maximum difference between ith elements of the rightMax array and the
        prices array'''
        m=0
        for i in range(n):
            m=max(m, rightMax[i]-prices[i])
        return m
