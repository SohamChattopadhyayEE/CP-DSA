# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        return self.binarySearch(root, val)
    def binarySearch(self, root, val):
        if root==None:
            return None
        if root.val==val:
            return root
        rootLeft = None
        rootRight = None
        if val<root.val:
            rootLeft = self.binarySearch(root.left, val)
        else:
            rootRight = self.binarySearch(root.right, val)
        if rootLeft == None:
            return rootRight
        else:
            return rootLeft
