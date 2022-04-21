'''
Algoritm:
-------------------------------------------------------------------
1. Initiate the DP table (say dp) with n+1 elements where n is the 
   length of string `s`. 
2. Initiate the base condition as `True` (dp[0]=True).
3. Iterate throught the string `s` and string `t` 
-------------------------------------------------------------------
'''
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        dp = [False]*(len(s)+1)
        dp[0] = True
        ind = 0
        for i in range(1,len(s)+1):
            for j in range(ind, len(t)):
                if s[i-1]==t[j]:
                    dp[i]=True and dp[i-1]
                    ind = j+1
                    break
        return dp[len(s)]
