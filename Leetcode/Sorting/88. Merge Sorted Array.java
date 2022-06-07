/*
Algorithm:
------------------------------------------------------------------------------
1. Initiate two pointers (`i` and `j`) pointing to the `0th` element of the arrays `nums1` and `nums2` respectively. 
   In addition to this, Initiate an empty dynamic `list` (ArrayList<Integer>() for `JAVA`). 
2. Iterate through both of the arrays in a single while loop as long as none of the pointers reaches the length of
   any one of the array. 
3. Each time compare the elements of the arrays and the smaller one is to be put to the dynamic `list` initiated before
   than that.
4. Once the while loop is over, the smaller array is completely interated over and the larger one is still left. 
5. Iterate to the rest of the elements of the larger array and keep adding them to the list.
6. Replace the elements of `nums1` with the elements of the list. 
------------------------------------------------------------------------------
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> temp = new ArrayList<>();
        int i = 0, j = 0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j])
                temp.add(nums1[i++]);
            else
                temp.add(nums2[j++]);
        }
        while(i<m)
            temp.add(nums1[i++]);
        while(j<n)
            temp.add(nums2[j++]);
        for(int k=0; k<m+n; k++)
            nums1[k] = temp.get(k);
    }
}
