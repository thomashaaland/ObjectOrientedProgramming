#include "Person.h"
#include <iostream>

Person::Person(Bil3* bilen) : bil(std::move(bilen)) { }
void Person::skrivBilNummer() {
  std::cout << "Personens bilnummer er " << bil->hentNummer() << "." << std::endl;
}
