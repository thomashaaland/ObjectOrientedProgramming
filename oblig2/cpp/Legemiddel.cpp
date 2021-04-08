#include "Legemiddel.h"
#include <utility>

Legemiddel::Legemiddel(const char* navn, double pris, double virkestoff)
  : m_navn(std::move(navn)), m_pris(std::move(pris)), m_virkestoff(std::move(virkestoff))
{}

std::ostream& operator<<(std::ostream& out, const Legemiddel& L) {
  return out << "Legemiddel ";
}

Narkotisk::Narkotisk(const char* navn, double pris, double virkestoff, int styrke)
  : Legemiddel{ navn, pris, virkestoff }, m_styrke(std::move(styrke))
{}

std::ostream& operator<<(std::ostream& out, const Narkotisk& N) {
  return out << "Narkotisk ";
}
