def lengthOfLastWord(s):
    length = len(s)
    flag = False
    for i in range(length - 1, -1, -1):
        if s[i] != " ":
            k = i
            break
    for i in range(k, -1, -1):
        if s[i] == " ":
            flag = True
            break
    if flag:
        return k - i
    else:
        return k - i + 1

s = "   moon   "
print(lengthOfLastWord(s))