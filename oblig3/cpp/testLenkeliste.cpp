#include "Liste.h"
#include <iostream>

void testTom()
{
  std::cout << "Tester tom liste" << std::endl;
  Liste<int>* liste = new Lenkeliste<int>;
}

int main()
{
  testTom();
  return 0;
}
