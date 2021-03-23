#include "Person.h"
#include <iostream>

Person::Person(Bil3* bilen) : bil(std::move(bilen))
{
  std::cout << "Person created!" << std::endl;
}
Person::~Person()
{
  std::cout << "Person destructed!" << std::endl;
}
void Person::skrivBilNummer() {
  std::cout << "Personens bilnummer er " << bil->hentNummer() << "." << std::endl;
}
