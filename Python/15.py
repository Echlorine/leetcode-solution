class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        l2 = []
        nums.sort()
        for a in range(len(nums)):
            if a != 0 and nums[a] == nums[a-1]:
                continue
            i = a + 1 # 左指针
            j = len(nums) - 1 # 右指针
            for b in range(len(nums)):
                if i >= j: # 左右指针不应该相碰
                    break
                if i != a + 1 and nums[i] == nums[i - 1]: # 第二个数也不应该出现重复的情况
                    i += 1
                    continue
                if nums[a] + nums[i] + nums[j] == 0:
                    stack = []
                    stack.append(nums[a])
                    stack.append(nums[i])
                    stack.append(nums[j])
                    l2.append(stack)
                    i += 1
                    continue
                if nums[a] + nums[i] + nums[j] < 0:
                    i += 1
                    continue
                if nums[a] + nums[i] + nums[j] > 0:
                    j -= 1
                    continue    
        return l2