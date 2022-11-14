inp = input()
res = ""
separators = ["-", " "]
a = 0
for index, char in enumerate(inp):
    if char in separators:
        word = inp[a:index]
        print(f"{word = }")
        a = index+1
        l = len(word)
        if l:
            if l % 2 == 0:
                print(f"{word[:l//2] = }")
                print(f"{word[l//2] = }")
                print(f"{word[l//2:] = }")
                word = word[:l//2] + chr(ord(word[0]) + 1) + word[l//2:]
            else:
                word = word[:l//2] + word[l//2+1:]
            res += word
        else:
            res += char

        print(f"{word = }")
print(f"{res = }")
