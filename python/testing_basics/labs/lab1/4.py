# Пользователь вводит строку из произвольного числа символов. В середину каждого слова (если четное число символов) добавить соседний справа символ из таблицы кодировки для первого символа слова; если нечетное количество символов в слове, то требуется удалить центральный символ. Словом считается конструкция, отделенная знаками препинания, пробелами или служебными символами.

string = input("enter string: ")
punctuation = (",", ".", "!", "?", ":", ";", " ", "/")


def change_word(word):
    if len(word) % 2 == 0:
        return word[: len(word) // 2] + chr(ord(word[0]) + 1) + word[len(word) // 2:]
    return word[: len(word) // 2] + word[len(word) // 2 + 1:]


word = ""
newstring = ""
flag = False
for index, symbol in enumerate(string):
    if symbol in punctuation:
        flag = True
        if not word:
            newstring += symbol
            continue
        changed_word = change_word(word)
        newstring += changed_word + symbol
        word = ""
    else:
        flag = False
        word += symbol
if word:
    changed_word = change_word(word)
    newstring += changed_word
print(f'{newstring = }')
