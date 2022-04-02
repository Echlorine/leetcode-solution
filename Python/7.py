def reverse(x):
    num = [] # 存储符号位每一位的数字
    if x >= 0:
        num.append(1) # 非负数
    else:
        num.append(-1)
    x = abs(x)
    # 获取每一位的数字
    while x >= 10:
        num.append(x % 10)
        x = int(x / 10)
    num.append(x)

    # 反转数字
    res = 0
    length = len(num) - 1
    for i in range(length):
        res += num[i+1] * (10 ** (length - i -1))
    res = res * num[0]
    if res <= 2 ** 31 - 1 and res >= -(2 ** 31):
        return res
    else:
        return 0
print(reverse(-0))