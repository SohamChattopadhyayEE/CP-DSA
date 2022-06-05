/*
Algorithm:
---------------------------------------------------------------------------------------------------
1. Firstly create a blank chess board with no queens placed on it and a global variable say `count`
   to calculate the number of possible solutions.
2. The intuition is to placing queens at a particular column from `1st` row to the `nth` row.
3. That is, in each recursive `backtracking` call (`dfs`), the row is incremented by one and 
   the call overs when the row reaches the value `n`.
4. In each backtracking call, the algorithm places a queen (`Q`) at every column possible and 
   checks if by placing the queen at that column the algorithm can reach to the last leaf of
   the state space tree. If it can then placing the `Q` at that point is valid and if not then
   it backtracks.
5. When the the algorithm hits the base condition, i.e. the current row becomes equal to `n`
   then the global variable `count` is incremented by one.
6. After the backtracking algorithm is completely exhausted, we return the variable `count`. 
---------------------------------------------------------------------------------------------------
*/

class Solution {
    int count=0;
    public int totalNQueens(int n) {
        String val = "";
        for(int i=0; i<n; i++)
            val +='.';
        List<String> temp = new ArrayList<>();
        for(int i=0; i<n; i++)
            temp.add(val);
        dfs(n, 0, temp);
        return count;
    }
    public void dfs(int n, int row, List<String> temp){
        if(row == n){
            count++;
            return;
        }
        for(int col=0; col<n; col++){
            if(isSafe(n, row, col, temp)){
                String r = temp.get(row);
                String t = r.substring(0, col)+'Q'+r.substring(col+1);
                temp.set(row, t);
                dfs(n, row+1, temp);
                temp.set(row, r);                
            }
        }
    }
    public boolean isSafe(int n, int row, int col, List<String> temp){
        // Same column
        for(int r=row-1; r>=0; r--)
            if(temp.get(r).charAt(col) == 'Q')
                return false;
        
        // Principle diagonal
        for(int r=row-1, c=col-1; r>=0 && c>=0; r--, c--)
            if(temp.get(r).charAt(c) == 'Q')
                return false;
        
        // Second siagonal
        for(int r=row-1, c=col+1; r>=0 && c<n; r--, c++)
            if(temp.get(r).charAt(c) == 'Q')
                return false;
        return true;
    }
}
