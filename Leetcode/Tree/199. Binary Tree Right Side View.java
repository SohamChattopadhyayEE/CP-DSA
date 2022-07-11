/*
Algorithm:
-------------------------------------------------------------------------------------
1. Perform Level Order Traversal (BFS) to store each node of the tree in level by 
   level manner.
2. Store last element of each level of the tree in a list which eventually happens
   to be the right most element of that level.
3. Return the list. 
-------------------------------------------------------------------------------------
*/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> curr = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(root == null)
            return temp;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n.left != null)
                curr.add(n.left);
            if(n.right != null)
                curr.add(n.right);
            temp.add(n.val);
            if(q.isEmpty()){
                res.add(temp);
                temp = new ArrayList<>();
                q = curr;
                curr = new LinkedList<>();
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<res.size(); i++)
            result.add(res.get(i).get(res.get(i).size()-1));
        return result; 
    }
}
