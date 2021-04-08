#ifndef LEGEMIDDEL_H
#define LEGEMIDDEL_H

#include <ostream>

class Legemiddel {
 private:
  const char* m_navn;
  double m_pris;
  double m_virkestoff;
 public:
  Legemiddel(const char* navn, double pris, double virkestoff);
};

class Narkotisk: public Legemiddel {
 private:
  int m_styrke;
 public:
  Narkotisk(const char* navn, double pris, double virkestoff, int styrke);
  friend std::ostream& operator<<(std::ostream& out, const Narkotisk& N);
};

std::ostream& operator<<(std::ostream& out, const Narkotisk& N);

#endif
