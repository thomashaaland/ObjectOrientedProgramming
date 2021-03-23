#include "Baat.h"
#include <iostream>
#include <sstream>

int Baat::m_antProd = 0;
Baat::Baat(const char* navn) : m_navn(navn), m_prodnr(m_antProd++)
{
  std::cout << "Baat created!" << std::endl;
}
Baat::~Baat()
{
  std::cout << "Baat destructed!" << std::endl;
}
String Baat::hentInfo()
{
  std::stringstream ss;
  ss << "Produksjonsnummer: " << m_prodnr << ", navn: " << m_navn;
  return ss.str();
}
