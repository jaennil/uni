inp = input()
inp_split = inp.split()
for i in range(len(inp_split)):
    inp_split[i] = inp_split[i][::-1]
print(' '.join(inp_split))
