#include "Brev.h"
#include <iostream>

Brev::Brev(String avsender, String mottaker) :
  m_avsender(std::move(avsender)), m_mottaker(std::move(mottaker)) { }

void Brev::skrivLinje(String linje) {
  m_linjer.push_back(linje);
}

void Brev::lesBrev() {
  std::cout << "Hei, " << m_mottaker << "." << std::endl;
  std::cout << std::endl;
  for (String linje : m_linjer) {
    std::cout << linje << std::endl;
  }
  std::cout << std::endl;
  std::cout << "Hilsen fra, " << std::endl;
  std::cout << m_avsender << std::endl;
}
