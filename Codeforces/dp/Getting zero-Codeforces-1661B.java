/*package whatever //do not write package name here */
import java.util.*;
//import java.io.*;

class cp{
    static final int mod = 32768;
    public static int steps(int n){
        int ans = 20;
        for(int i=0; i<=15; i++){
            for(int j=0; j<=15; j++){
                if((n+i)*Math.pow(2,j)%mod == 0)
                    ans = Math.min(ans, i+j);
            }
        }
        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int i=0;
        while(i<n){
            int m =sc.nextInt();
            int r = steps(m);
            System.out.println(r);
            i++;
        }
        sc.close();        
    }
}
