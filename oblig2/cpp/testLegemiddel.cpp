#include "Legemiddel.h"
#include <memory>

int main() {
  std::unique_ptr<Narkotisk> n1(new Narkotisk("Narko", 250.2, 2.2, 10));
  
  return 0;
}
