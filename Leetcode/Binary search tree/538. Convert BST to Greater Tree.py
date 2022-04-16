# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        lis=[]
        self.inorder(root, lis)
        n=len(lis)
        i=n-2
        suffSum=lis.copy()
        while i>=0:
            suffSum[i]+=suffSum[i+1]
            i-=1
        self.convert(root, suffSum, lis)
        return root
    def convert(self, root, suffSum, lis):
        if root:
            root.val = suffSum[lis.index(root.val)]
            self.convert(root.left, suffSum, lis)
            self.convert(root.right, suffSum, lis)
        
    def inorder(self, root, lis):
        if root:
            self.inorder(root.left, lis)
            lis.append(root.val)
            self.inorder(root.right, lis)
