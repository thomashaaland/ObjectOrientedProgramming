#include <memory>
#include <iostream>
#include "Legemiddel.h"
#include "Resept.h"
#include "Lege.h"

int main() {
  /*
    Opprett legemidler
  */
  const std::shared_ptr<Vanlig> paracet(new Vanlig("Paracet", 109.99, 0.25));
  const std::shared_ptr<Narkotisk> opium(new Narkotisk("Opium", 199.9, 0.95, 2));
  const std::shared_ptr<Vanlig> ppille(new Vanlig("P-pille", 200, 0.47));

  std::cout << *paracet << std::endl;
  std::cout << *opium << std::endl;
  std::cout << *ppille << std::endl;
  
  /*
    Opprett leger
  */
  std::shared_ptr<Lege> jensen(new Lege("Jensen"));
  std::shared_ptr<Lege> lesteberg(new Lege("Lesteberg"));
  std::shared_ptr<Lege> ingenmannsland(new Lege("Ingenmannsland"));

  std::cout << *jensen << std::endl;
  std::cout << *lesteberg << std::endl;
  std::cout << *ingenmannsland << std::endl;
  
  /*
    Opprett resepter
  */
  std::unique_ptr<Hvitresept> jensParacet(new Hvitresept(paracet, jensen, 123, 2));

  std::cout << *jensParacet << std::endl;
  
  return 0;
}
