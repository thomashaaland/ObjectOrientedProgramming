#include "Resept.h"

// Resept
Resept::Resept(const std::shared_ptr<Legemiddel> &legemiddel,
	       const std::shared_ptr<Lege> &lege,
	       int pasientId,
	       int reit)
  : m_id(s_count++),
    m_legemiddel(std::move(legemiddel)),
    m_lege(std::move(lege)),
    m_pasientId(pasientId),
    m_reit(reit)
{ }

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
		 const std::shared_ptr<Spesialist> &lege,
		 int pasientId)
  : Hvitresept(legemiddel, std::static_pointer_cast<Lege>(lege), pasientId, s_pReit)
{ }

const char* Presept::farge() const
{
  return "P r";
}
const double Presept::prisAaBetale() const
{
  return m_legemiddel->hentPris() - s_avslag;
}

/*
  Militaerresept
*/
Militaerresept::Militaerresept(const std::shared_ptr<Legemiddel> &legemiddel,
			       const std::shared_ptr<Spesialist> &lege,
			       int pasientId, int reit)
  : Hvitresept(legemiddel, std::static_pointer_cast<Lege>(lege), pasientId, reit)
{ }
const double Militaerresept::prisAaBetale() const
{
  return Militaerresept::s_prisAaBetale;
}

/*
  Blaaresept
*/
Blaaresept::Blaaresept(const std::shared_ptr<Legemiddel>& legemiddel,
		       const std::shared_ptr<Lege>& lege,
		       int pasientId, int reit)
  : Resept(legemiddel, lege, pasientId, reit)
{ }
const char* Blaaresept::farge() const
{
  return "Blaa r";
}
const double Blaaresept::prisAaBetale() const
{
  return m_legemiddel->hentPris() * (1 - rabatt);
}

// Static declarations
int Resept::s_count = 0;
int Presept::s_avslag = 108;
int Presept::s_pReit = 3;
int Militaerresept::s_prisAaBetale = 0;

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
std::ostream& operator<<(std::ostream& out, const Militaerresept& M)
{
  const Hvitresept* H = &M;
  return out << *H;
}
std::ostream& operator<<(std::ostream& out, const Blaaresept& B)
{
  const Resept* R = &B;
  return out << *R << "Pris: " << B.prisAaBetale();;
}
