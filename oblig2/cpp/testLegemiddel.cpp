#include "Legemiddel.h"
#include <memory>
#include <iostream>

int main() {
  std::unique_ptr<Narkotisk> n1(new Narkotisk("Narko", 250.2, 2.2, 10));
  std::unique_ptr<Vanedannende> v1(new Vanedannende("Vane", 200.1, 1.2, 20));
  std::unique_ptr<Vanlig> va1(new Vanlig("Vanlig", 150.0, 0.2));
  
  std::cout << *n1 << std::endl;
  std::cout << *v1 << std::endl;
  std::cout << *va1 << std::endl;
  
  return 0;
}
