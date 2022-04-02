def romanToInt(s):
    dict = {'I' : 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000,
            'IV': 4,
            'IX': 9,
            'XL': 40,
            'XC': 90,
            'CD': 400,
            'CM': 900
    }
    
    res = 0
    j = 0
    for i in range(len(s)):
        if i != j:
            continue
        if s[j] == 'I':
            if j+1 >= len(s):
                res += dict['I']
                break
            if (s[j]+s[j+1]) == 'IV':
                res += dict['IV']
                j += 2
                continue
            elif (s[j]+s[j+1]) == 'IX':
                res += dict['IX']
                j += 2
                continue
            else:
                res += dict['I']
                j += 1
                continue
        if s[j] == 'X':
            if j+1 >= len(s):
                res += dict['X']
                break
            if (s[j]+s[j+1]) == 'XL':
                res += dict['XL']
                j += 2
                continue
            elif (s[j]+s[j+1]) == 'XC':
                res += dict['XC']
                j += 2
                continue
            else:
                res += dict['X']
                j += 1
                continue
        if s[j] == 'C':
            if j+1 >= len(s):
                res += dict['C']
                break
            if (s[j]+s[j+1]) == 'CD':
                res += dict['CD']
                j += 2
                continue
            elif (s[j]+s[j+1]) == 'CM':
                res += dict['CM']
                j += 2
                continue
            else:
                res += dict['C']
                j += 1
                continue
        if s[j] == 'V':
            res += dict['V']
            j += 1
            continue
        if s[j] == 'L':
            res += dict['L']
            j += 1
            continue
        if s[j] == 'D':
            res += dict['D']
            j += 1
            continue
        if s[j] == 'M':
            res += dict['M']
            j += 1
            continue
    print(res)
romanToInt('MCMXCIV')