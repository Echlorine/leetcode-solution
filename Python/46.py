class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res = []
        def back(S):
            if len(S) == n:
                res.append(self.mycopy(S))
                return 
            for i in nums:
                if i not in S:
                    S.append(i)
                    back(S)
                    S.pop()
        back([])
        return res
    
    def mycopy(self, a):
        # 将列表a的值全部复制到b中，并且返回b
        b = a[:]
        return b