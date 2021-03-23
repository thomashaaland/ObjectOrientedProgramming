#include "Bil.h"
#include <iostream>

Bil::Bil(const char* navn, const char* merke) : m_navn(navn), m_bilmerke(merke) { }
void Bil::skrivInfo()
{
  std::cout << "Eieren av bilen er " << m_navn;
  std::cout << " og merket er " << m_bilmerke << "." << std::endl;
}
