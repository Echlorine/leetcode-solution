def isValid(s):
    parentheses = {'}':'{',
                   ']':'[',
                   ')':'('}
    # str = []
    # # 处理原字符串
    # for i in range(int(len(s) / 2)):
    #     if s[i] == '(' or s[i] == '{' or s[i] == '[' or s[i] == ')' or s[i] == '}' or s[i] == ']':
    #         str.append(s[i])
    if (len(s) % 2) == 1:
        return False
    str = []
    for i in range(len(s)):
        if s[i] == '(' or s[i] == '{' or s[i] == '[': # 左括号入栈
            str.append(s[i])
        if s[i] == ')' or s[i] == '}' or s[i] == ']': # 遇到右括号则弹出栈顶元素
            if len(str) == 0:
                return False
            if str.pop() == parentheses[s[i]]:
                continue
            else:
                return False
    # 栈为空则匹配成功
    if len(str) == 0:
        return True
    else:
        return False
    

print((isValid("({([])})")))