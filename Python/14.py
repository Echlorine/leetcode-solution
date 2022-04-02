strs = ["flower","flow","flight"]

def longestCommonPrefix(strs):
    length = len(strs[0])
    for i in range(len(strs)):
        t = len(strs[i])
        if t < length:
            length = t
    for i in range(len(strs)):
        if len(strs[i]) == length:
            break
    res = ""
    for j in range(len(strs[i])):
        # 比较各个单词的对应字母
        for k in range(len(strs)):
            if k == i:
                continue
            if strs[i][j] == strs[k][j]:
                continue
            else:
                return res
        res += strs[i][j]
    return res

print(longestCommonPrefix(strs))