#include <memory>
#include <iostream>
#include "Lege.h"
#include "Legemiddel.h"
#include "Resept.h"

int main() {
  // Initier leger
  std::shared_ptr<Lege> lege(new Lege("Hansen\t"));
  std::shared_ptr<Spesialist> spesialist(new Spesialist("Lesteberg", 123));

  // Initier legemiddler
  std::shared_ptr<Vanlig> vanlig(new Vanlig("Vanlig\t", 100, 200));
  std::shared_ptr<Vanedannende> vanedannende(new Vanedannende("Vanedannende", 200, 300, 5));
  std::shared_ptr<Narkotisk> narkotisk(new Narkotisk("Narkotisk", 300, 400, 10));

  // Initer resepter
  std::unique_ptr<Hvitresept> hvitresept(new Hvitresept(vanlig, lege, 5, 10));
  std::unique_ptr<Militaerresept>
    militaerresept(new Militaerresept(narkotisk, spesialist, 5, 10));
  std::unique_ptr<Presept> presept(new Presept(vanedannende, spesialist, 5));
  std::unique_ptr<Blaaresept> blaaresept(new Blaaresept(vanlig, lege, 5, 10));

  // Skriv ut info
  // Leger
  std::cout << "Leger:" << std::endl;
  std::cout << *lege << std::endl;
  std::cout << *spesialist << std::endl;

  // Legemidler
  std::cout << "Legemidler:" << std::endl;
  std::cout << *vanlig << std::endl;
  std::cout << *vanedannende << std::endl;
  std::cout << *narkotisk << std::endl;

  // Resepter
  std::cout << "Resepter:" << std::endl;
  std::cout << *hvitresept << std::endl;
  std::cout << *militaerresept << std::endl;
  std::cout << *presept << std::endl;
  std::cout << *blaaresept << std::endl;
  
  return 0;
}
