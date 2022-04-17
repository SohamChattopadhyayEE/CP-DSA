class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        temp = self.root_n = TreeNode(None)
        self.inorder(root)
        
        # Since temp itself has null value and the desired tree starts from right of it, we return `temp.right`
        return temp.right
    
    def inorder(self, root):
        if not root:
            return 
        self.inorder(root.left)
        
        # The inorder operation
        root.left=None # As the algorithm already have traversed through the left-most node, let the left be made `Null`
        
        # Assign the current node of the recursion stack to the right node of the new TreeNode
        self.root_n.right=root
        
        # For further recursion call, let the new node go one step ahed towards its right 
        self.root_n=root

        self.inorder(root.right)
