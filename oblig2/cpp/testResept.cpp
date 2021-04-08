#include <memory>
#include "Resept.h"

int main() {
  std::unique_ptr<Vanlig> paracet(new Vanlig("Paracet", 109.99, 0.25));
  
  return 0;
}
