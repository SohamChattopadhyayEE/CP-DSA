class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0)
            return 0;
        int i=0, j=i+1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(i));
        int max = Integer.MIN_VALUE;
        while(j<n){
            char ch = s.charAt(j);
            while(set.contains(ch)){
                max = Math.max(max, set.size());
                set.remove(s.charAt(i++));
            }
            set.add(ch);
            j++;
        }
        return Math.max(max, set.size());
    }
}
