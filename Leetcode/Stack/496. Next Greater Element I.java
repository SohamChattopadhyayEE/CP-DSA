/*
Algorithm:
-------------------------------------------------------------------------------------
1. The idea is to prepare a HashMap having the 'keys' being the elements of nums2
and corresponding 'values' being the next greater elements with the help of a stack.
2. Traverse from the end of the nums2.
3. For any element of nums2, if the stack is found empty put the next greater element 
of it as -1 in the Map
4. If the peek element of the stack is less than the ith element of the array nums2,
pop it up. Keep doing this as long as greater element occurs or stack becomes empty.
5. Thereafter repear step 3.
6. Hence, we have a HashMap containing elements of nums2 and next greater elements of 
each element.
7. Finally, return an array of length same as that of nums1 where ith element of which
is the next grater element in nums2 of ith element of nums1 extracted from the HashMap
filled earlier.
---------------------------------------------------------------------------------------
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1];
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=n2-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<nums2[i])
                stack.pop();
            map.put(nums2[i], stack.isEmpty()?-1:stack.peek());
            stack.push(nums2[i]);
        }
        for(int i=0; i<n1; i++){
            res[i]=map.get(nums1[i]);
        }        
        return res;
    }
}
