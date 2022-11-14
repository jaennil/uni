inp = input()
inp_splited = inp.split()
for index, word in enumerate(inp_splited):
    if len(word) % 2 == 0:
        inp_splited[index] = word[:len(word)//2] + \
            chr(ord(word[0]) + 1) + word[len(word)//2:]
    else:
        inp_splited[index] = word[:len(word)//2] + word[len(word)//2+1:]
string_result = ' '.join(inp_splited)


# task 5
print("tesk 5")
print("words amount: ", len(inp_splited))
marks = ['.', ',', ';', ':', '!', '?', '-', '(', ')', '"', "'"]
marks_amount = 0
for mark in marks:
    marks_amount += string_result.count(mark)
print("marks amount: ", marks_amount)
print(string_result)
