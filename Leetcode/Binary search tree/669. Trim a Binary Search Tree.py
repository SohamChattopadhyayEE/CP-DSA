# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:
        return self.trim(root, low, high)
    def trim(self, root, l, h):
        if not root:
            return root
        if root.val>h:
            return self.trim(root.left, l, h)
        if root.val<l:
            return self.trim(root.right, l, h)
        
        root.left=self.trim(root.left, l, h)
        root.right=self.trim(root.right, l, h)
        
        return root
