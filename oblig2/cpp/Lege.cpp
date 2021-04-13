#include "Lege.h"

Lege::Lege(const char* navn) : m_navn(std::move(navn)) { };
const char* Lege::hentNavn() const
{
  return m_navn;
}

std::ostream& operator<<(std::ostream& out, const Lege& L)
{
  return out << "Lege " << L.hentNavn();
}
