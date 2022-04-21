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
