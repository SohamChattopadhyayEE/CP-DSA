class Solution {
    int m;
    public String getHappyString(int n, int k) {
        m=n;
        char[] arr = {'a', 'b', 'c'};
        PriorityQueue<String> pq = new PriorityQueue<>();
        dfs(arr, "", pq);
        while(k-->1)
            pq.poll();
        return pq.peek() == null ? "" : pq.peek();
    }
    public void dfs(char[] arr, String temp, PriorityQueue<String> pq){
        if(temp.length() == m){
            pq.add(temp);
            return;
        }
        for(int i=0; i<3; i++){
            if(temp.length()>0){
                if(arr[i] != temp.charAt(temp.length()-1)){
                    temp = temp+arr[i];
                    dfs(arr, temp, pq);
                    temp = temp.substring(0,temp.length()-1);
                }
            }
            else{
                temp = temp+arr[i];
                dfs(arr, temp, pq);
                temp = temp.substring(0,temp.length()-1);
            }
        }
    }
}
