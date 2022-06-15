class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length()-b.length());
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for(int i=1; i<n; i++)
            for(int j=0; j<i; j++)
                if(isPred(words[j], words[i]))
                    lis[i] = Math.max(lis[i], lis[j]+1);
        int max = 0;
        for(int m : lis)
            max = Math.max(max, m);
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
