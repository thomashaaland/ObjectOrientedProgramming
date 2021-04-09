#ifndef LEGEMIDDEL_H
#define LEGEMIDDEL_H

#include <ostream>

/*
  Classes
*/

class Legemiddel {
 public:
    static int count;

 private:
  const int m_id;
  const char* m_navn;
  double m_pris;
  const double m_virkestoff;
 public:
  Legemiddel(const char* navn, double pris, const double virkestoff);

  const int hentId() const;
  const char* hentNavn() const;
  double hentPris() const;
  const double hentVirkestoff() const;
  
  friend std::ostream& operator<<(std::ostream& out, const Legemiddel& L);
};

class Narkotisk: public Legemiddel {
 private:
  int m_styrke;
 public:
  Narkotisk(const char* navn, double pris, const double virkestoff, const int styrke);
  const int hentStyrke() const;
  
  friend std::ostream& operator<<(std::ostream& out, const Narkotisk& N);
};

class Vanedannende: public Legemiddel {
 private:
  const int m_vanedannendeStyrke;

 public:
  Vanedannende(const char* navn, double pris, const double virkestoff,
	       const int vanedannendeStyrke);
  const int hentVaneStyrke() const;
  
  friend std::ostream& operator<<(std::ostream& out, const Vanedannende& V);
};

class Vanlig: public Legemiddel {
 public:
  Vanlig(const char* navn, double pris, const double virkestoff);
  
  friend std::ostream& operator<<(std::ostream& out, const Vanlig& V);
};

/*
  friend functions
*/

std::ostream& operator<<(std::ostream& out, const Legemiddel& L);
std::ostream& operator<<(std::ostream& out, const Narkotisk& N);
std::ostream& operator<<(std::ostream& out, const Vanedannende& V);
std::ostream& operator<<(std::ostream& out, const Vanlig& V);

#endif
