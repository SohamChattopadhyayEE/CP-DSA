# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev=ListNode(None)
        node=ListNode(None)
        curr=head
        node.next=prev
        prev.next=curr
        dic = {}
        while curr:
            if curr.val not in dic:
                dic[curr.val] = 1
            else:
                dic[curr.val] += 1
            curr = curr.next
        curr=head
        while curr:
            while curr and dic[curr.val]>1:
                curr = curr.next
            prev.next=curr
            if curr:
                curr=curr.next
                prev=prev.next
        return node.next.next
            
