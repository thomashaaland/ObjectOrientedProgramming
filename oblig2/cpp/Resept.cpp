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

const double Hvitresept::prisAaBetale() const
{
  return m_legemiddel->hentPris();
}

// Presept
Presept::Presept(const std::shared_ptr<Legemiddel> &legemiddel,
		 const std::shared_ptr<Lege> &lege,
		 int pasientId)
  : Hvitresept(legemiddel, lege, pasientId, pReit)
{ }

const char* Presept::farge() const
{
  return "P r";
}
const double Presept::prisAaBetale() const
{
  return m_legemiddel->hentPris() - avslag;
}

// Static declarations
int Presept::avslag = 108;
int Presept::pReit = 3;

/*
  Friend function definitions
*/
std::ostream& operator<<(std::ostream& out, const Resept& R)
{
  return out << R.farge() << "esept\tID: " << R.hentId() << "\t" <<
    R.hentLegemiddel()->hentNavn() << "\t| Utsteder: " << *R.hentLege() <<
    "\t| PasientID: " << R.hentPasientId() << "\t| N resepter igjen: " <<
    R.hentReit() << "\t| ";
}

std::ostream& operator<<(std::ostream& out, const Hvitresept& H)
{
  const Resept* B = &H;
  return out << *B << "Pris: " << H.prisAaBetale();
}
std::ostream& operator<<(std::ostream& out, const Presept& P)
{
  const Hvitresept* H = &P;
  return out << *H;
}
