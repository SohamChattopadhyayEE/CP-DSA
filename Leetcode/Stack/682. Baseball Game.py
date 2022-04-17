class Solution:
    def calPoints(self, ops: List[str]) -> int:
        res=[0]*len(ops)
        count=0
        for i in range(len(ops)):
            tempn=len(res)
            if ops[i]=="+":
                res.append(res[tempn-1]+res[tempn-2])
            elif ops[i]=="D":
                res.append(2*res[tempn-1])
            elif ops[i]=="C":
                res.pop(tempn-1)
            else:
                res.append(int(ops[i]))

        return sum(res)
