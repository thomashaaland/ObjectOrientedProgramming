#include "Spesialist.h"

Spesialist::Spesialist(const char* name, int kontrollID)
  : Lege(std::move(name)), m_kontrollID(kontrollID)
{ }

Spesialist::hentKontrollID()
{
  return kontrollID;
}
