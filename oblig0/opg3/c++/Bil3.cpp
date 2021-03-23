#include "Bil3.h"
#include <iostream>

Bil3::Bil3(std::string nummer) : bilnummer(std::move(nummer))
{
  std::cout << "Bil created!" << std::endl;
}
std::string Bil3::hentNummer() { return bilnummer; }
Bil3::~Bil3() { std::cout << "Bil destructed!" << std::endl; }
