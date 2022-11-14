#include "main.h"
#include <chrono>
#include <iostream>
#include <stdio.h>
#include <string>
#include <typeinfo>

int main(int argc, char *argv[]) {
  srand(time(NULL));
  for (int ndx{}; ndx != argc; ++ndx) {
    std::cout << "argv[" << ndx << "] == " << argv[ndx] << '\n';
    // parse cli arguments here
  }
  //    std::cout << "argv[" << argc << "] == "
  //             << static_cast<void*>(argv[argc]) << '\n';

  std::cout << password_generator(8, false) << std::endl;
  return EXIT_SUCCESS;
}

std::string password_generator(int length, bool special_characters) {
  std::string alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0"
                         "123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
  std::string password;
  if (special_characters) {
    for (int i = 0; i < length; i++) {
      short random_number = rand() % 94; // 94 is length of the alphabet
      password += alphabet[random_number];
    }
  } else {
    for (int i = 0; i < length; i++) {
      short random_number =
          rand() %
          62; // 62 is length of the alphabet without special_characters
      password += alphabet[random_number];
    }
  }
  return password;
}

void test() {}
