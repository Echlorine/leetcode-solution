def strStr(haystack="milissip", needle="issi"):
    if not needle: # 空字符串直接返回0
        return 0
    if len(haystack) < len(needle): # 长度不符合，直接退出
        return -1

    # 匹配
    for i in range(len(haystack) - len(needle) + 1):
        flag = True
        for j in range(len(needle)):
            if needle[j] != haystack[i + j]:
                flag = False
                break
        if flag:
            return i
    return -1

print(strStr())