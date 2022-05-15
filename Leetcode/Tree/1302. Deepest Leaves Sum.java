/*
Solution 1: Breath-First-Search (BFS) (Level Order Traversal) 

Algorithm:
---------------------------------------------------------------
A `Level Order Traversal` based approach. Simply perform
lever order traversal throughout the tree and find the leaves
of the last level. Store them in a list and return the sum 
of the values of the elements of the list. 
---------------------------------------------------------------
*/

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> curr = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
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
                q=curr;
                curr = new LinkedList<>();
                temp = new ArrayList<>();
            }
        }
        int sum = 0;
        for(int i : res.get(res.size()-1))
            sum += i;
        return sum;
    }
}

/*
Solution 2: Depth-First-Search (DFS)

Algorithm:
---------------------------------------------------------------
1. Store the value and depth of each node in an object as 
   pairs.
2. Perform Depth-First-Search (DFS) from the root node and 
   store the val and depth of the leaf node in a priority 
   queue in such a way that they are sorted based-on their
   depths from high to low.
3. Return the sum of the values of the leaves which have the 
   maximum values of depth. 
---------------------------------------------------------------
*/

class obj{
    int val, d;
    obj(int val, int d){
        this.val = val;
        this.d = d;
    }
}
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int depth = 0;
        int max_depth = 0;
        PriorityQueue<obj> pq = new PriorityQueue<>((a, b) -> b.d-a.d);
        dfs(root, depth, pq);
        int sum = 0;
        max_depth = pq.peek().d;
        while(!pq.isEmpty() && pq.peek().d == max_depth)
            sum += pq.poll().val;
        return sum;
    }
    public void dfs(TreeNode root, int d, PriorityQueue<obj> pq){
        if(root.right == null && root.left == null)
            pq.add(new obj(root.val, d));
        
        if(root.left != null)
            dfs(root.left, d+1, pq);
        if(root.right != null)
            dfs(root.right, d+1, pq);
    }
}
