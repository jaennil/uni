import random


digits = '0123456789'
alphabet_lower = 'qwertyuiopasdfghjklzxcvbnm'
alphabet_upper = 'QWERTYUIOPASDFGHJKLZXCVBNM'
symbols = '!#%:,.;*()[]{}<>/?@&-+='
global_alphabet = {0: digits, 1: alphabet_lower, 2: alphabet_upper, 3: symbols}


def validate(string):
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


def generate_password(length: int):
    result = ""
    while not validate(result):
        result = ""
        for _ in range(length):
            symbol_type = random.randint(0, 3)
            alph = global_alphabet[symbol_type]
            result += alph[random.randint(0, len(alph)-1)]
    return result
