class Solution:
    def myAtoi(self, s: str) -> int:
        stack  = []
        flag  = 1
        fflag = False
        i = 0
        count = 0
        count1 = 0
        n = len(s)
        if n == 0:
            return 0
        if n == 1 and (s[i] < '0' or s[i] >'9'):
            return 0
        while i < n:
            
            if s[i] >= '0' and s[i] <= '9':    
                fflag = True
                if i != 0 and count == 0:
                    j = i - 1
                    if s[j] != ' ' and s[j] != '+' and s[j] != '-':
                        return 0
                    else:
                        for k in range(j):
                            if s[k] != ' ':
                                return 0
                count += 1
                stack.append(s[i])
            else:
                
                count1 += 1
                if count1 == n:
                    return 0
                if fflag:
                    break
                if s[i] == '-':
                    flag = -1
            i += 1
        
        res = int(''.join(stack)) * flag
        if res > pow(2,31) - 1:
            return pow(2,31) - 1
        if res < -1 * pow(2,31):
            return -1 * pow(2,31)
        return res