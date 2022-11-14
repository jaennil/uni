# 0 unset 1 increase -1 decrease
mode = 0
current_length = 0
max_length = 0
cnt = 0
unchanged_amount = 1
while True:
    current = input()
    if cnt == 0:
        previous = current

    # increase
    if current > previous:
        print("increase")
        # if increase
        if mode == 1:
            current_length += 1
            max_length = max(current_length, max_length)
        # if decrease
        elif mode == -1:
            max_length = max(current_length, max_length)
            current_length = unchanged_amount
        elif mode == 0:
            current_length+=1
            max_length = max(current_length, max_length)
        mode = 1
        unchanged_amount = 1
    # decrease
    elif current < previous:
        print("decrease")
        # if increase
        if mode == 1: 
            max_length = max(current_length, max_length)
            current_length = unchanged_amount
        # if decrease
        elif mode == -1:
            current_length += 1
            max_length = max(current_length, max_length)
        elif mode == 0:
            current_length+=1
            max_length = max(current_length, max_length)
        mode = -1
        unchanged_amount = 1
    # unchange
    else:
        print("unchange")
        current_length += 1
        unchanged_amount += 1
        max_length = max(current_length, max_length)

    print(f"{max_length = }")
    print(f"{mode = }")
    print(f"{current_length = }")

    previous = current
    cnt += 1


