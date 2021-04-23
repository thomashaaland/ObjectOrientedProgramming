#include "Lege.h"

Lege::Lege(const char* navn) : m_navn(std::move(navn)) { };
const char* Lege::hentNavn() const
{
  return m_navn;
}

Spesialist::Spesialist(const char* name, int kontrollID)
  : Lege(std::move(name)), m_kontrollID(kontrollID)
{ }

int Spesialist::hentKontrollID()
{
  return m_kontrollID;
}


std::ostream& operator<<(std::ostream& out, const Lege& L)
{
  return out << "Lege " << L.hentNavn();
}
std::ostream& operator<<(std::ostream& out, const Spesialist& S)
{
  return out << "Spesialist " << (Lege) S;
}
