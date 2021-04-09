#include <memory>
#include "Legemiddel.h"
#include "Resept.h"

int main() {
  /*
    Opprett legemidler
  */
  std::unique_ptr<Vanlig> paracet(new Vanlig("Paracet", 109.99, 0.25));
  std::unique_ptr<Narkotisk> opium(new Narkotisk("Opium", 199.9, 0.95, 2));
  std::unique_ptr<Vanlig> ppille(new Vanlig("P-pille", 200, 0.47));

  /*
    Opprett resepter
  */
  

  return 0;
}
