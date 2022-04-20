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
class BSTIterator {
    TreeNode node;
    int ptr;
    List<Integer> tree = new ArrayList<Integer>();
    public BSTIterator(TreeNode root) {
        this.node = root;
        this.ptr = 0;
        inorder(root);
    }
    
    public int next() {
        int val = tree.get(this.ptr);
        this.ptr++;
        return val;
    }
    
    public boolean hasNext() {
        return this.ptr+1<=tree.size();
    }
    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        tree.add(root.val);
        inorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
