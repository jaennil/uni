from utils import s_box, rcon, multiply2_matrix, multiply3_matrix


def xor_strings(string1: str, string2: str) -> list[list[int]]:
    """takes 2 strings and return 4x4 matrix with xored string"""
    # append zeros to end of the string
    string1 = "{:<016s}".format(string1)
    string2 = "{:<016s}".format(string2)

    xored_matrix = [[-1 for _ in range(4)] for _ in range(4)]
    # write string to matrix
    string1_matrix = string_to_matrix(string1)
    string2_matrix = string_to_matrix(string2)

    # xor ascii values of strings
    for x in range(4):
        for y in range(4):
            xored_matrix[x][y] = int(
                ord(string1_matrix[x][y]) ^ ord(string2_matrix[x][y])
            )
    return xored_matrix


def key_expansion():
    ...


def left_shift(num: int, amount: int) -> int:
    """takes int return bitwise shift to left string"""
    return int("0b" + bin(num)[2 + amount:] + "0" * amount, base=2)


def generate_round_keys(key: list[list[int]]):
    """takes key and return list of 4x4 matrices with round keys"""
    print_2dimensional_array_hex(key, "key")
    temp = key[0][3]
    for i in range(3):
        key[i][3] = key[i + 1][3]
    key[3][3] = temp
    print_2dimensional_array_hex(key, "key after left shift")
    hexed_key = matrix_to_hex_matrix(key)
    aes_hexed_key = hex_matrix_to_aes_hex_matrix(hexed_key)
    for i in range(4):
        row = int("0x" + aes_hexed_key[i][3][2:3], base=16)
        col = int("0x" + aes_hexed_key[i][3][3:4], base=16)
        key[i][3] = s_box[row][col]
    print_2dimensional_array_hex(key, "key after s box")
    constant = [0x01, 0x00, 0x00, 0x00]
    for i in range(4):
        key[i][3] ^= constant[i]
    print_2dimensional_array_hex(key, "after xor with constant")
    test = [0xb3, 0x6e, 0xcb, 0xb7]
    for i in range(4):
        test[i] ^= constant[i]
        print(hex(test[i]))
    test2 = ['s', 'o', 'm', 'e']
    for i in range(4):
        test2[i] = ord(test2[i])
    result = []
    for i in range(4):
        result.append(test2[i] ^ test[i])
        print(hex(result[i]))

    
    




def add_round_key(
    state_matrix: list[list[int]], roundkey_matrix: list[list[int]]
) -> list[list[int]]:
    add_round_key_matrix = [[-1 for _ in range(4)] for _ in range(4)]

    for y in range(4):
        for x in range(4):
            add_round_key_matrix[y][x] = state_matrix[y][x] ^ roundkey_matrix[y][x]
    return add_round_key_matrix


def string_to_matrix(string: str) -> list[list[str]]:
    """takes string and writes it to matrix. if length of string is less than 16 it appends 0 to the end"""
    # append 0 to end of the string
    string = "{:<016s}".format(string)
    string_matrix = [["" for _ in range(4)] for _ in range(4)]
    for x in range(4):
        for y in range(4):
            string_matrix[x][y] = string[y * 4 + x]
    return string_matrix


def string_to_regular_matrix(string: str):
    """takes string and writes it to matrix. if length of string is less than 16 it appends 0 to the end"""
    # append 0 to end of the string
    string = "{:<016s}".format(string)
    string_matrix = [[-1 for _ in range(4)] for _ in range(4)]
    for x in range(4):
        for y in range(4):
            string_matrix[x][y] = string[x * 4 + y]
    return string_matrix


def string_matrix_to_ascii_matrix(matrix: list[list[str]]) -> list[list[int]]:
    """takes string matrix and return int matrix with ascii values"""

    ascii_matrix = [[-1 for _ in range(4)] for _ in range(4)]
    for x in range(4):
        for y in range(4):
            ascii_matrix[x][y] = ord(matrix[x][y])
    return ascii_matrix


def matrix_to_hex_matrix(matrix: list[list[int]]) -> list[list[str]]:
    """takes int 4x4 matrix and return 4x4 matrix with str hex values"""
    hex_matrix = [["" for _ in range(4)] for _ in range(4)]
    for x in range(len(matrix[0])):
        for y in range(len(matrix)):
            hex_matrix[y][x] = hex(matrix[y][x])
    return hex_matrix


def hex_matrix_to_aes_hex_matrix(matrix: list[list[str]]) -> list[list[str]]:
    """takes hex matrix and append zeros to the length 4 e.g. 0xf -> 0x0f"""
    aes_hex_matrix = [["" for _ in range(4)] for _ in range(4)]
    for x in range(len(matrix[0])):
        for y in range(len(matrix)):
            if len(matrix[y][x]) == 4:
                aes_hex_matrix[y][x] = matrix[y][x]
            else:
                aes_hex_matrix[y][x] = "0x0" + matrix[y][x][2]
    return aes_hex_matrix


def print_2dimensional_array(two_dimensional_array, name="default name"):
    print("---print 2dimensional array " + name + "---")
    for i in two_dimensional_array:
        print(i)
    print("---end print 2dimensional array " + name + "---")
    print()


def print_2dimensional_array_hex(two_dimensional_array, name="default name"):
    print("---print 2dimensional array hex" + name + "---")
    for i in two_dimensional_array:
        print(list(map(hex, i)))
    print("---end print 2dimensional array hex" + name + "---")
    print()


def sub_bytes(matrix: list[list[int]]) -> list[list[int]]:
    """aes bytes substitution"""
    hexed_matrix = matrix_to_hex_matrix(matrix)
    aes_hexed_matrix = hex_matrix_to_aes_hex_matrix(hexed_matrix)
    sub_bytes_matrix = [[-1 for _ in range(4)] for _ in range(4)]
    for y in range(4):
        for x in range(4):
            row = int("0x" + aes_hexed_matrix[y][x][2:3], base=16)
            col = int("0x" + aes_hexed_matrix[y][x][3:4], base=16)
            sub_bytes_matrix[y][x] = s_box[row][col]
    return sub_bytes_matrix


def shift_rows(matrix):
    """aes shift rows"""
    matrix[1] = matrix[1][1:] + matrix[1][:1]
    matrix[2] = matrix[2][2:] + matrix[2][:2]
    matrix[3] = matrix[3][3:] + matrix[3][:3]
    return matrix


def matrix_multiplication(matrix1, matrix2):
    # ! not working
    """if a is an m*n matrix and b is an n*p matrix"""
    m = len(matrix1)
    n = len(matrix1[0])
    if n != len(matrix2):
        return "wrong input"
    p = len(matrix2[0])


def multiply3(num: int) -> int:
    """aes GF multiplication by 3"""
    x = int(convert_hex_to_str_aes_hex(num)[2], base=16)
    y = int(convert_hex_to_str_aes_hex(num)[3], base=16)
    return multiply3_matrix[x][y]


def convert_hex_to_str_aes_hex(num: int) -> str:
    if len(hex(num)) != 4:
        return "0x0" + hex(num)[2]
    else:
        return hex(num)


def multiply2(num: int) -> int:
    """aes GF multiplication by 2"""
    str_aes_hex_num = convert_hex_to_str_aes_hex(num)
    x = int(str_aes_hex_num[2], base=16)
    y = int(str_aes_hex_num[3], base=16)
    return multiply2_matrix[x][y]


def mix_columns(input_matrix: list[list[int]]) -> list[list[int]]:
    result_matrix = [[-1 for _ in range(4)] for _ in range(4)]
    for x in range(4):
        for y in range(4):
            temp = []
            for rcon_xy in range(4):
                # cell_result ^= rcon[y][rcon_xy] * input_matrix[x][rcon_xy]
                if rcon[y][rcon_xy] == 2:
                    temp.append(multiply2(input_matrix[rcon_xy][x]))
                elif rcon[y][rcon_xy] == 3:
                    temp.append(multiply3(input_matrix[rcon_xy][x]))
                elif rcon[y][rcon_xy] == 1:
                    temp.append(input_matrix[rcon_xy][x])
                else:
                    print("mix columns rcon wrong value")
            result_matrix[y][x] = temp[0] ^ temp[1] ^ temp[2] ^ temp[3]
    return result_matrix


def encryption(text, key):
    text_matrix = string_to_matrix(text)
    key_matrix = string_to_matrix(key)
    text_ascii_matrix = string_matrix_to_ascii_matrix(text_matrix)
    print_2dimensional_array_hex(text_ascii_matrix, "after text ascii matrix")
    key_ascii_matrix = string_matrix_to_ascii_matrix(key_matrix)
    generate_round_keys(key_ascii_matrix)
    print_2dimensional_array_hex(key_ascii_matrix, "after text ascii matrix")
    state = text_ascii_matrix
    state = add_round_key(state, key_ascii_matrix)
    print_2dimensional_array_hex(state, "after first add round key")
    for _ in range(10):
        state = sub_bytes(state)
        print_2dimensional_array_hex(state, name="after sub bytes")
        state = shift_rows(state)
        print_2dimensional_array_hex(state, "after shift rows")
        state = mix_columns(state)
        print_2dimensional_array_hex(state, "after mix columns")
        print_2dimensional_array_hex(state, "state")
        print_2dimensional_array_hex(key_ascii_matrix, "key_ascii_matrix")
        state = add_round_key(state, text_ascii_matrix)
        print_2dimensional_array_hex(state, "after add_round_key")


TEXT = "ATTACK AT DAWN!"
KEY = "SOME 128 BIT KEY"
# xor_strings(text, key)
TEXT2 = "Two One Nine Two"
KEY2 = "Thats my Kung Fu"

encryption(TEXT2, KEY2)
# text2_matrix = string_to_matrix(text2)
# print_2dimensional_array(text2_matrix, name="text2_matrix")
# key2_matrix = string_to_matrix(key2)
# print_2dimensional_array(key2_matrix, name="key2_matrix")
#
# text2_ascii_matrix = string_matrix_to_ascii_matrix(text2_matrix)
# text2_ascii_matrix_hex = matrix_to_hex_matrix(text2_ascii_matrix)
# print_2dimensional_array(text2_ascii_matrix_hex, name="text2_ascii_matrix_hex")
#
# key2_ascii_matrix = string_matrix_to_ascii_matrix(key2_matrix)
# key2_ascii_matrix_hex = matrix_to_hex_matrix(key2_ascii_matrix)
# print_2dimensional_array(key2_ascii_matrix_hex, name="key2_ascii_matrix_hex")
#
# add_round_key_matrix = add_round_key(text2_ascii_matrix, key2_ascii_matrix)
# add_round_key_matrix_hex = matrix_to_hex_matrix(add_round_key_matrix)
# print_2dimensional_array(add_round_key_matrix_hex, name="add_round_key_matrix")
#
# sub_bytes_matrix = sub_bytes(add_round_key_matrix)
# sub_bytes_matrix_hex = matrix_to_hex_matrix(sub_bytes_matrix)
# print_2dimensional_array(sub_bytes_matrix_hex, name="sub_bytes_matrix")
#
# shift_rows_matrix = shift_rows(sub_bytes_matrix)
# print_2dimensional_array(shift_rows_matrix, "shift_rows_matrix")
#
# aes_visual_matrix = [[0x87, 0x0a, 0x0b, 0x1a],
#                      [0x16, 0x1b, 0x56, 0x83],
#                      [0x47, 0xf1, 0x13, 0xbb],
#                      [0xe7, 0xd5, 0xc6, 0x28]]
# # for i in range(4):
# # for j in range(4):
# #aes_visual_matrix[i][j] = str(aes_visual_matrix[i][j])
#
# mixed_columns = mix_columns(shift_rows_matrix)
# mixed_columns_hexed = matrix_to_hex_matrix(mixed_columns)
# print_2dimensional_array(mixed_columns_hexed)
#
# print(f"{bin(multiply2(0x63)) = }")
# print(f"{bin(multiply3(0x2f)) = }")
