#include <memory.h>
#include <stdio.h>
#include <stdlib.h>
#include <string>
#define LENGTH 16
int main() {
  char const plainone[LENGTH] = "attack at dawn!";
  char const plaintwo[LENGTH] = "some 128 bit ke";
  char asd[LENGTH];

  for (int i = 0; i < LENGTH; ++i) {
    asd[i] = (char)(plainone[i] ^ plaintwo[i]);
  }
  for (int i = 0; i < LENGTH; ++i) {
    printf("%02X", asd[i]);
  }
  return 0;
}
