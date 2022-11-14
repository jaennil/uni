import random


def create_random_array():
    return [random.randint(-100, 30) for i in range(random.randint(20, 50))]


random_array = create_random_array()
s_random_array = random_array.copy()

negative_amount = 0
for num in random_array:
    if num < 0:
        negative_amount += 1
print(f"{negative_amount = }")

while negative_amount > len(random_array)/2:
    print(f"{random_array = }")

    negative_amount = 0
    for num in random_array:
        if num < 0:
            negative_amount += 1
    print(f"{negative_amount = }")

    for i in range(len(random_array)):
        if random.randint(1, 2) % 2 == 0:
            random_array[i] *= -1

    print(f"array after random negatiation {random_array}")

positive_even_amount = 0
for i in range(1, len(random_array), 2):
    if random_array[i] > 0 and random_array[i] % 2 == 0:
        positive_even_amount += 1

negative_digit_amount = 0
for num in random_array:
    if num < 0:
        negative_digit_amount += len(str(num)) - 1

even_numbers_sum = 0
for i in range(0, len(random_array), 2):
    if random_array[i] % 2 != 0:
        even_numbers_sum += random_array[i]

end_sum = positive_even_amount + negative_digit_amount + even_numbers_sum
if end_sum % 2 == 0:
    for i in range(len(random_array)):
        if random_array[i] < 0:
            random_array[i] += end_sum
else:
    for i in range(len(random_array)):
        if random_array[i] < 0:
            random_array[i] -= end_sum

with open("3.txt", "w") as f:
    f.write(str(s_random_array))
    f.write("\n")
    f.write(str(random_array))
