#include "Liste.h"
#include <iostream>

void testTom()
{
  std::cout << "Tester tom liste" << std::endl;
  Liste<std::string>* liste = new Lenkeliste<std::string>;
}

int main()
{
  testTom();
  return 0;
}
