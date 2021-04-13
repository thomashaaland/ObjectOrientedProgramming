#include "Resept.h"

// Resept
Resept::Resept(const std::shared_ptr<Legemiddel> &legemiddel,
	       const std::shared_ptr<Lege> &lege,
	       int pasientId,
	       int reit)
  : m_id(count++),
    m_legemiddel(std::move(legemiddel)),
    m_lege(std::move(lege)),
    m_pasientId(pasientId),
    m_reit(reit)
{ }
int Resept::count = 0;

// Getters defs
const int Resept::hentId() const
{
  return m_id;
}
const std::shared_ptr<Legemiddel> Resept::hentLegemiddel() const
{
  return m_legemiddel;
}
const std::shared_ptr<Lege> Resept::hentLege() const
{
  return m_lege;
}
const int Resept::hentPasientId() const
{
  return m_pasientId;
}
const int Resept::hentReit() const
{
  return m_reit;
}
const char* Resept::farge() const
{
  return "R";
}
const bool Resept::bruk()
{
  if (m_reit <= 0)
    return false;
  else
    {
      m_reit--;
      return true;
    }
}

// Hvitresept
Hvitresept::Hvitresept(const std::shared_ptr<Legemiddel> &legemiddel,
		       const std::shared_ptr<Lege> &lege,
		       int pasientId,
		       int reit)
  : Resept(legemiddel, lege, pasientId, reit)
{ }


const char* Hvitresept::farge() const
{
  return "Hvitr";
}

/*
const double prisAaBetale()
{
  return 0;
}
*/

/*
  Friend function definitions
*/
std::ostream& operator<<(std::ostream& out, const Resept& R)
{
  return out << R.farge() << "esept\tID: " << R.hentId() << "\t på " <<
    R.hentLegemiddel()->hentNavn() << "\tUtsteder: " << *R.hentLege() <<
    "\tPasientID:\t" << R.hentPasientId() << "\tN resepter igjen: " << R.hentReit();
}

std::ostream& operator<<(std::ostream& out, const Hvitresept& H)
{
  const Resept* B = &H;
  return out << *B;
}

