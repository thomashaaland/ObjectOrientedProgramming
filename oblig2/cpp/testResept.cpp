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
    Opprett leger m/ hack for formatering
  */
  std::shared_ptr<Lege> lege(new Lege("Jensen\t"));
  std::shared_ptr<Spesialist> spesialist(new Spesialist("Lesteberg", 123));
  
  std::cout << *lege << std::endl;
  std::cout << *spesialist << std::endl;
  
  /*
    Opprett resepter
  */
  std::unique_ptr<Hvitresept>
    jensParacet(new Hvitresept(paracet, lege, 123, 2));
  std::unique_ptr<Presept>
    astridPpille(new Presept(ppille, spesialist, 124));
  std::unique_ptr<Militaerresept>
    knudsenOpium(new Militaerresept(opium, spesialist, 125, 10));
  
  std::cout << *jensParacet << std::endl;
  std::cout << *astridPpille << std::endl;
  std::cout << *knudsenOpium << std::endl;
  
  jensParacet->bruk();
  jensParacet->bruk();
  jensParacet->bruk();
  std::cout << *jensParacet << std::endl;

  astridPpille->bruk();
  astridPpille->bruk();
  astridPpille->bruk();
  std::cout << *astridPpille << std::endl;

  knudsenOpium->bruk();
  knudsenOpium->bruk();
  knudsenOpium->bruk();
  std::cout << *knudsenOpium << std::endl;
  
  return 0;
}
