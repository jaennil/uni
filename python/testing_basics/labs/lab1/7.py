from tkinter import W
from PIL import Image, ImageDraw, ImageFont
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


def calculate_font_size(string):
    for font_size in range(1, 1000):
        lines = write_lines(string, font_size)
        if lines["left_vertical_space"] < 0:
            l = write_lines(string, font_size - 1)
            return {"font_size": font_size - 1, "field": l["field"]}


def write_lines(string, font_size):
    sstring = string
    font = ImageFont.truetype(r"C:\\Windows\\Fonts\\arial.ttf", font_size)
    biggest_symbol_width = font.getbbox('M')[2]
    biggest_symbol_height = font.getbbox('W')[3]
    field = {}
    taken_vertical_space = 0
    left_vertical_space = height

    slicer = 0
    for i in range(1, len(string) + 1):
        tstring = string[slicer:i]
        tstring_width = font.getbbox(tstring)[2]

        if tstring_width + biggest_symbol_width >= width:
            field[taken_vertical_space] = tstring
            slicer = i
            taken_vertical_space += biggest_symbol_height + 10
            left_vertical_space -= biggest_symbol_height + 10
    keys = [key for key in field]
    if keys and field[keys[-1]] != tstring:
        field[taken_vertical_space] = tstring
        taken_vertical_space += biggest_symbol_height
        left_vertical_space -= biggest_symbol_height
    return {"field": field, "left_vertical_space": left_vertical_space}


def add_noise(image):
    for x in range(width):
        for y in range(height):
            r = random.randint(0, 1)
            if r:
                image.putpixel((x, y), (0, 255, 0))


def draw_line(image):
    image.line([(0, 360), (720, 0)], fill="yellow", width=1)


num = int(input())
digits = '0123456789'
alphabet_lower = 'qwertyuiopasdfghjklzxcvbnm'
alphabet_upper = 'QWERTYUIOPASDFGHJKLZXCVBNM'
symbols = '!#%:,.;*()[]{}<>/?@&-+='
global_alphabet = {0: digits, 1: alphabet_lower, 2: alphabet_upper, 3: symbols}

output = ""
while not validation(output):
    output = ""
    for i in range(num):
        symbol_type = random.randint(0, 3)
        alph = global_alphabet[symbol_type]
        output += alph[random.randint(0, len(alph)-1)]

print(f"{output = }")

width = 720
height = 360
canvas = Image.new('RGB', (width, height), 'white')

img_draw = ImageDraw.Draw(canvas)
l = calculate_font_size(output)
font = ImageFont.truetype(r"C:\\Windows\\Fonts\\arial.ttf", l["font_size"])
for y in l["field"]:
    img_draw.text((0, y), l["field"][y], fill='red', font=font)

add_noise(canvas)
draw_line(img_draw)
canvas.save('7.jpg')
