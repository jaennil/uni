import random


def validation(string):
    for digit in digits:
        if digit in string:
            break
    else:
        return False

    for lchar in alphabet_lower:
        if lchar in string:
            break
    else:
        return False

    for uchar in alphabet_upper:
        if uchar in string:
            break
    else:
        return False

    for symbol in symbols:
        if symbol in string:
            break
    else:
        return False

    return True


num = int(input())
digits = '0123456789'
alphabet_lower = 'qwertyuiopasdfghjklzxcvbnm'
alphabet_upper = 'QWERTYUIOPASDFGHJKLZXCVBNM'
symbols = '!#%:,.;*()[]{}<>/?@&-+='
global_alphabet = {0: digits, 1: alphabet_lower, 2: alphabet_upper, 3: symbols}

# first method
result = ""
while not validation(result):
    result = ""
    for i in range(num):
        symbol_type = random.randint(0, 3)
        alph = global_alphabet[symbol_type]
        result += alph[random.randint(0, len(alph)-1)]

print(result)
