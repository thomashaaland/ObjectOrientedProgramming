#include "Person.h"
#include <iostream>

Person::Person(String navn, String telefonNummer, String adresse) :
  m_navn(std::move(navn)),
  m_telefonNummer(std::move(telefonNummer)),
  m_adresse(std::move(adresse)) { }

String Person::hentNavn() {
  return m_navn;
}

void Person::skrivInfo() {
  std::cout << "Navn: " << m_navn << " : TelefonNummer: ";
  std::cout << m_telefonNummer;
  std::cout << " : Adresse: " << m_adresse << std::endl;
}
