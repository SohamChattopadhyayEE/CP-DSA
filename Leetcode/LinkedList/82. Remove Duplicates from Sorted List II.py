'''
Algorithm:
------------------------------------------------------------------------------------
1. Traverse through the list and make a frequecy array using a dictionary (Map).
2. Have two pointer nodes `curr` and `prev`, where the `curr` is pointing to the 
head and `prev.next` points to the `curr`.
3. Initiate a dummy node say `node` such that
                    node.next=prev
4. Re-iterate through the list again and skip those nodes havin occuring frequency
more than 1.
5. Return node.next.next
------------------------------------------------------------------------------------
'''

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
            
