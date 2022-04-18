/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
Algorithm: 
-----------------------------------------------------------------------
1. Perform `Inorder` traversal and fill inorder list which happens to 
be a sorted list.
2. Since it is 0th indexed list, return the (k-1)th element from the 
list which is the kth smallest element.
-----------------------------------------------------------------------
*/
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res.get(k-1);
    }
    public void inorder(TreeNode root, List<Integer> res){
        if(root != null){
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }
}
