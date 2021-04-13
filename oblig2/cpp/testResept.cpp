#include <memory>
#include <iostream>
#include "Legemiddel.h"
#include "Resept.h"
#include "Lege.h"

int main() {
  /*
    Opprett legemidler
  */
  const std::unique_ptr<Vanlig> paracet(new Vanlig("Paracet", 109.99, 0.25));
  const std::unique_ptr<Narkotisk> opium(new Narkotisk("Opium", 199.9, 0.95, 2));
  const std::unique_ptr<Vanlig> ppille(new Vanlig("P-pille", 200, 0.47));

  std::cout << *paracet << std::endl;
  std::cout << *opium << std::endl;
  std::cout << *ppille << std::endl;
  
  /*
    Opprett leger
  */
  std::unique_ptr<Lege> jensen(new Lege("Jensen"));
  std::unique_ptr<Lege> lesteberg(new Lege("Lesteberg"));
  std::unique_ptr<Lege> ingenmannsland(new Lege("Ingenmannsland"));

  std::cout << *jensen << std::endl;
  std::cout << *lesteberg << std::endl;
  std::cout << *ingenmannsland << std::endl;
  
  /*
    Opprett resepter
  */
  //std::uniquue_ptr<Hvitresept> jensParacet(new Hvitresept(

  return 0;
}
