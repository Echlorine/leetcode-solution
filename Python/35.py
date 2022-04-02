def searchInsert(nums, target):
    length = len(nums)
    for i in range(length):
        if nums[i] == target:
            break
        if nums[i] > target:
            break
    if nums[i] < target:
        return i + 1
    return i

print(searchInsert(nums = [1,3,5,6], target = 5))
print(searchInsert(nums = [1,3,5,6], target = 2))
print(searchInsert(nums = [1,3,5,6], target = 7))