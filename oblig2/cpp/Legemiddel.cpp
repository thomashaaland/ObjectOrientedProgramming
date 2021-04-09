#include "Legemiddel.h"
#include <utility>

/* 
   Legemiddel
*/
Legemiddel::Legemiddel(const char* navn, double pris, const double virkestoff)
  : m_navn(std::move(navn)), m_pris(std::move(pris)), m_virkestoff(std::move(virkestoff)),
    m_id(std::move(count++))
{}
int Legemiddel::count = 0;
const int Legemiddel::hentId() const { return m_id; }
const char* Legemiddel::hentNavn() const { return m_navn; }
double Legemiddel::hentPris() const { return m_pris; }
const double Legemiddel::hentVirkestoff() const { return m_virkestoff; }

std::ostream& operator<<(std::ostream& out, const Legemiddel& L) {
  return out << "ID: " << L.hentId() << "\t- Navn: " << L.hentNavn() <<
    "\t- Pris: " << L.hentPris() << "\t- Virkestoff: " << L.hentVirkestoff();
}

/*
  Narkotisk
*/
Narkotisk::Narkotisk(const char* navn, double pris, const double virkestoff, const int styrke)
  : Legemiddel{ navn, pris, virkestoff }, m_styrke(std::move(styrke))
{}
const int Narkotisk::hentStyrke() const { return m_styrke; }

std::ostream& operator<<(std::ostream& out, const Narkotisk& N) {
  return out << "Narkotisk " << (Legemiddel) N << "\t- Styrke: " << N.hentStyrke();
}
