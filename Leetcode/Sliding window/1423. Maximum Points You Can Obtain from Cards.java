class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, totalSum = 0, minSum = 0;
        k = n-k;
        for(int i=0, currSum=0; i<n; i++){
            totalSum += cardPoints[i];
            currSum += cardPoints[i];
            if(i<k) minSum += cardPoints[i];
            else{
                currSum -= cardPoints[i-k];
                minSum = Math.min(minSum, currSum);
            }
        }
        return totalSum - minSum;
    }
}
