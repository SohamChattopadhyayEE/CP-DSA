import java.io.*;
import java.util.*;

class SegmentTree {
    static int[] a = new int[10000];
    static int[] st = new int[4*10000];
    public static void buildST(int idx, int low, int high){
        if(low==high){
            st[idx]=a[low];
            return;
        }
        int mid = low+(high-low)/2;
        buildST(2*idx+1, low, mid);
        buildST(2*idx+2, mid+1, high);
        st[idx]=Math.max(st[2*idx+1], st[2*idx+2]);
        
    }
    public static int query(int idx, int low, int high, int l, int r){
        /*Case 1:  Completely lies within*/
        if(low>=l && high<=r){
            return st[idx];
        }
        
        /*Case 2: Lies outside*/
        if(high<l || low>r)
            return Integer.MIN_VALUE;
        
        /*Case 3: Overlaps*/
        int mid = low + (high-low)/2;
        int left = query(idx*2+1, low, mid, l, r);
        int right = query(idx*2+2, mid+1, high, l, r);
        return Math.max(left, right);
    }
    
    public static int searchST(int n, int l, int r){
        buildST(0, 0, n-1);
        return query(0, 0, n-1, l, r);
    }
    
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++)
            a[i]=sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int res = searchST(n, l, r);
        System.out.println(res);
	}
}
