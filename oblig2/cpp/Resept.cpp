#include "Resept.h"

Resept::Resept(const std::shared_ptr<Legemiddel> &legemiddel,
	       const std::shared_ptr<Lege> &lege)
  : m_id(count++)
{ }
int Resept::count = 0;

Hvitresept::Hvitresept(const std::shared_ptr<Legemiddel> &legemiddel,
		       const std::shared_ptr<Lege> &lege, int n1, int n2)
  : Resept(legemiddel, lege)
{ }
const int Resept::hentId() const
{
  return m_id;
}

/*
  Friend function definitions
*/
std::ostream& operator<<(std::ostream& out, const Resept& R)
{
  return out << "resept\tID: " << R.hentId() << "\t";
}
std::ostream& operator<<(std::ostream& out, const Hvitresept& H)
{
  return out << "Hvit" << (Resept) H;
}
