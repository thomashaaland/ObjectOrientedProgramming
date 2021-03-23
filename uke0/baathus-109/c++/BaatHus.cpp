#include "BaatHus.h"
#include <iostream>

BaatHus::BaatHus(int kapasitet) : m_kapasitet(kapasitet), m_nBaater(0)
{
  std::cout << "Baathus created!" << std::endl;
}
BaatHus::~BaatHus()
{  
  std::cout << "Baathus destructed!" << std::endl;
}
void BaatHus::settInn(const char* navn)
{
  if (m_nBaater < m_kapasitet)
    {
      baater.push_back(Baat(navn));
      m_nBaater++;
    }
  else
    {
      std::cout << "Det er fullt!" << std::endl;
    }
}
void BaatHus::skrivBaater()
{
  for (Baat b : baater)
    {
      std::cout << b.hentInfo() << std::endl;
    }
}
