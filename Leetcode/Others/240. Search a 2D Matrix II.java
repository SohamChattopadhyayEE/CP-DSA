/*
Algorithm:
--------------------------------------------------------------------------------------------
1. Start searching from the top right corner of the matrix.
2. if the `target` is less than the element at current position, move leftwards. Otherwise
   move downwards. 
3. If the target is found then return `true`.
4. If the traversal is completed and the target is not found return `false`.
--------------------------------------------------------------------------------------------
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r=0, c=n-1;
        while(r<m && r>=0 && c<n && c>=0){
            if(target == matrix[r][c])
                return true;
            else if(target<matrix[r][c])
                c--;
            else
                r++;
        }
        return false;
    }
}
