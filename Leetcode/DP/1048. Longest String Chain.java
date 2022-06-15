/*
Algorithm:
----------------------------------------------------------------------------------------------------------------
1. The given problem is simply a variation of typical `Longest Increasing Subsequence (LIS)` problem.  
2. Similar to `LIS` algorithm, here also we need to traverse through the entire array and maintain a dynamic
   array of length similar to the input array, `ith` element of which denotes the length of longest subsequence
   ending at `ith` element. 
3. Since `rearrangment` is allowed here, the words firstly need to get sorted based on the lengths of the words.
4. Thereafter the algorithm followed in `LIS` is applied here where the comparing is done by checking if one 
   string is predecessor to the other or not. 
5. The maximum value of the `LIS` array is returned.  
----------------------------------------------------------------------------------------------------------------
*/
class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        if(n==1)
            return 1;
        Arrays.sort(words, (a, b) -> a.length()-b.length());
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int max = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(isPred(words[j], words[i]))
                    lis[i] = Math.max(lis[i], lis[j]+1);
            }
            max = Math.max(max, lis[i]);
        }
        return max;
    }
    public boolean isPred(String s1, String s2){
        if(s1.length()+1 != s2.length())
            return false;
        int count = 0;
        int i=0, j=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i) != s2.charAt(j)){
                count++;
                if(count>1)
                    return false;
                j++;
            }
            else{
                i++;
                j++;
            }
        }
        return true;
    }
}
