/*
Algorithm:
---------------------------------------------------------------------------------
1. Build a Priority Queue containing all the combinations of given size of 
   strings containing the characters from the input string such that they are 
   automatically in lexicographically sorted form.
2. perform `BackTracking` algorithm to fill the Priority Queue with combinations
   of given length. 
3. The base condition of the recursion call is when the length of the temporary
   string is equal to the specified length, add that string to the Priority 
   Queue and backtrack.
4. When the method `next()` is called, return the String which is at the top of
   the Priority Queue.
5. In case of the method `hasNext()`, return `true` if the the Priority Queue
   is not null. Otherwise, return `false`.
---------------------------------------------------------------------------------
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
