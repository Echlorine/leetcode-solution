def plusOne(self, digits: List[int]) -> List[int]:
    k = 0
    for i in range(len(digits)-1 , -1, -1):
        if digits[i] < 9:
            digits[i]+= 1
            break
        else:
            k += 1
            digits[i] = 0
    if k == len(digits):
        digits.insert(0, 1)
    return digits