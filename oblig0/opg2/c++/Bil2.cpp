#include <iostream>
#include "Bil2.h"

Bil2::Bil2(std::string bilnr) : bilnummer(std::move(bilnr)){ }

void Bil2::skrivBilInfo() {
  std::cout << "Bilnummer: " << Bil2::bilnummer << std::endl;
}
