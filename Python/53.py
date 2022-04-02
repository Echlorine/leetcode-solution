def maxSubArray(nums) -> int:
    length = len(nums)
    res = temp = nums[0]
    for i in range(1, length):
        temp = max(temp + nums[i], nums[i])
        if temp > res:
            res = temp
    return res
nums = [-2,1,-3,4,-1,2,1,-5,4]
print(maxSubArray(nums))