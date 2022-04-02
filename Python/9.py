# def isPalindrome(x):
#     if x < 0:
#         return False
#     num = []
#     num.append(x)
#     while x >= 10:
#         num.append(x % 10)
#         x = int(x / 10)
#     num.append(x)
#     res = 0
#     length = len(num) - 1
#     for i in range(length):
#         res += num[i+1] * (10 ** (length - i -1))
#     if (res - num[0]) == 0:
#         return True
#     return False

def isPalindrome(x):
    if x < 0:
        return False
    num = []
    # 获取每一位
    while x >= 10:
        num.append(x % 10)
        x = int(x / 10)
    num.append(x)
    length = len(num)
    for i in range(int(length / 2)):
        if num[i] != num[length - 1 - i]:
            return False
    return True

print(isPalindrome(3593))