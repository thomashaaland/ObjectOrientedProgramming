#ifndef RESEPT_H
#define RESEPT_H

#include <memory>
#include "Legemiddel.h"
#include "Lege.h"

class Resept {
 public:
  static int count;  
 protected:
  int m_id, m_pasientId, m_reit;
  const std::shared_ptr<Legemiddel> m_legemiddel;
  const std::shared_ptr<Lege> m_lege;

  // Constructor
  Resept(const std::shared_ptr<Legemiddel> &legemiddel,
	 const std::shared_ptr<Lege> &lege,
	 int pasientId, int reit);

  // Getters
  const int hentId() const;
  const std::shared_ptr<Legemiddel> hentLegemiddel() const;
  const std::shared_ptr<Lege> hentLege() const;
  const int hentPasientId() const;
  const int hentReit() const;
  
  // Friends
  friend std::ostream& operator<<(std::ostream& out, const Resept& R);

  // Metode for aa bruke resepten
 public:
  const bool bruk();

  // Virtuals
  virtual const char* farge() const;
  //virtual const double prisAaBetale();

};
std::ostream& operator<<(std::ostream& out, const Resept& R);


class Hvitresept : public Resept {
 public:
  Hvitresept(const std::shared_ptr<Legemiddel> &legemiddel,
	     const std::shared_ptr<Lege> &lege, int n1, int n2); 
  const char* farge() const;
  //const double prisAaBetale();
  
  friend std::ostream& operator<<(std::ostream& out, const Hvitresept& H);
};
std::ostream& operator<<(std::ostream& out, const Hvitresept& H);

#endif
