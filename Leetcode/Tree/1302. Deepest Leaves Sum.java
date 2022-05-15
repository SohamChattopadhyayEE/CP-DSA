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
