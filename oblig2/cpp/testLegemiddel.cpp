#include "Legemiddel.h"
#include <memory>
#include <iostream>

int main() {
  std::unique_ptr<Narkotisk> n1(new Narkotisk("Narko", 250.2, 2.2, 10));

  std::cout << *n1 << std::endl;
  
  return 0;
}
