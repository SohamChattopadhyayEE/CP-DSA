# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findSecondMinimumValue(self, root: Optional[TreeNode]) -> int:
        def preorder(root, dic):
            if root:
                if root.val not in dic:
                    dic.append(root.val)
                preorder(root.left, dic)
                preorder(root.right, dic)
        dic = []
        preorder(root, dic)
        dic.sort()
        return dic[1] if len(dic) > 1 else -1 
