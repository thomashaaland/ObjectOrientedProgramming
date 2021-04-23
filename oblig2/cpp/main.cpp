#include <memory>
#include "Lege.h"
#include "Legemiddel.h"
#include "Resept.h"

int main() {
  // Initier leger
  std::shared_ptr<Lege> lege(new Lege("Hansen"));
  std::shared_ptr<Spesialist> spesialist(new Spesialist("Lesteberg", 123));

  // Initier legemiddler
  std::shared_ptr<Vanlig> vanlig(new Vanlig("Vanlig", 100, 200));
  std::shared_ptr<Vanedannende> vanedannende(new Vanedannende("Vanedannende", 200, 300, 5));
  std::shared_ptr<Narkotisk> narkotisk(new Narkotisk("Narkotisk", 300, 400, 10));

  // Initer resepter
  std::unique_ptr<Hvitresept> hvitresept(new Hvitresept(vanlig, lege, 5, 10));
  std::unique_ptr<Militaerresept>
    militaerresept(new Militaerresept(narkotisk, spesialist, 5, 10));
  std::unique_ptr<Presept> presept(new Presept(vanedannende, spesialist, 5));
  
  
  return 0;
}
