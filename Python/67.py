def addBinary(a, b):
    llen = max(len(a), len(b))
    mlen = min(len(a), len(b))
    res = ""
    carry = 0 # 标记是否进位
    for i in range(-1, -llen - 1, -1):
        if i >= -mlen:
            if int(a[i]) + int(b[i]) + carry >= 2:
                res += str((int(a[i]) + int(b[i]) + carry) % 2)
                carry = 1
                continue
            res += str(int(a[i]) + int(b[i]) + carry)
            carry = 0
            continue
        if len(a) > len(b):
            if int(a[i]) + carry >= 2:
                res += str((int(a[i]) + carry) % 2)
                carry = 1
                continue
            res += str(int(a[i]) + carry)
            carry = 0
        else:
            if int(b[i]) + carry >= 2:
                res += str((int(b[i]) + carry) % 2)
                carry = 1
                continue
            res += str(int(b[i]) + carry)
            carry = 0
    if carry == 1:
        res += str(carry)
    return res[::-1] # 翻转结果


a = "1010"
b = "1011"
print(addBinary(a, b))