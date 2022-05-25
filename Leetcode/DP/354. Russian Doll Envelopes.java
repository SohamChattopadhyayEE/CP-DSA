/*
Solution 1: Sorting + Dynamic Programming - Time Limit Exceeded 
*/

class newComparator implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        return (a[0]<b[0] && a[1]<b[1]) ? -1 : a[0]-b[0] + a[1]-b[1];
    }
}

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new newComparator());
        int n = envelopes.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1])
                    lis[i] = Math.max(lis[i], lis[j]+1);
            }
        }
        int m = Integer.MIN_VALUE;
        for(int i : lis)
            m = Math.max(m, i);
        return m;
    }
}
