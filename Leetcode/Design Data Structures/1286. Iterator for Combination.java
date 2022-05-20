/*
Algorithm:
-------------------------------------------------------------------------------
1. Build a Priority Queue containing all the combinations of given size of 
   strings containing the characters from the input string such that the are 
   automatically is sorted format.
2. 
*/

class CombinationIterator {
    PriorityQueue<String> pq = new PriorityQueue<String>();
    String input;
    int n;
    public CombinationIterator(String characters, int combinationLength) {
        input = characters;
        n = combinationLength;
        backtrack(new StringBuilder(), 0);
    }
    
    public String next() {
        return pq.poll();
    }
    
    public boolean hasNext() {
        return pq.size()>0;
    }
    private void backtrack(StringBuilder sb, int idx){
        if(sb.length() == n){
            pq.add(sb.toString());
        }
        for(int i=idx; i<input.length(); i++){
            sb.append(input.charAt(i));
            backtrack(sb, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
