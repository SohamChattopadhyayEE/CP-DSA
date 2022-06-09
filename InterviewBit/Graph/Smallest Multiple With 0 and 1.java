public class Solution {
    String[] bits = {"0","1"};
    public String multiple(int A) {
        Queue<String> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add("1");
        while(!q.isEmpty()){
            String s = q.poll();
            int rem = reminder(s, A);
            if(rem == 0)
                return s;
            if(!vis.contains(rem)){
                vis.add(rem);
                for(String bit : bits){
                    String f = s+bit;
                    q.add(f);
                }
            }
        }
        return "";        
    }
    public int reminder(String s, int n){
        int rem = 0;
        for(int i=0; i<s.length(); i++){
            rem = rem*10 + (s.charAt(i)-'0');
            rem %= n;
        }
        return rem;
    } 
}
