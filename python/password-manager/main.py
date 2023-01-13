from aes import decrypt, encrypt
from password_generator import generate_password
import sys
import pyperclip
import json
from getpass import getpass

def main():
    user_password = getpass("Enter your password: ")
    try:
        passwords = json.load(open('passwords.json'))
    except:
        passwords = {}
        print("No passwords found. Creating new file.")
    args = sys.argv[1:]
    length = 16
    tag = ""
    new_password = ""
    new = False
    for i, arg in enumerate(args):
        if arg == "-l":
            length = int(args[i+1])
        elif arg == "-n":
            new = True
        elif arg[0] != "-":
            if tag:
                if new_password:
                    print("too much arguments")
                    return
                new_password = arg
            else:
                tag = arg
    if new:
        password = generate_password(length)
        print(password)
        encrypted_password = encrypt(password, user_password)
        passwords[tag] = encrypted_password
        pyperclip.copy(password)
        json.dump(passwords, open('passwords.json', 'w'))
    else:
        if new_password:
            encrypted_password = encrypt(new_password, user_password)
            passwords[tag] = encrypted_password
            pyperclip.copy(new_password)
            json.dump(passwords, open('passwords.json', 'w'))
        else:
            encrypted_password = passwords[tag]
            password = decrypt(encrypted_password, user_password)
            pyperclip.copy(password)
            print(password)
    if not args:
        for tag in passwords:
            print(tag)


if __name__ == '__main__':
    main()


