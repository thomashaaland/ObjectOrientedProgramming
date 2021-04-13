#ifndef RESEPT_H
#define RESEPT_H

#include <memory>
#include "Legemiddel.h"
#include "Lege.h"

class Resept {
 public:
  static int count;
 protected:
  int m_id;
  Resept(const std::shared_ptr<Legemiddel> &legemiddel,
	 const std::shared_ptr<Lege> &lege);
  const int hentId() const;
  
  friend std::ostream& operator<<(std::ostream& out, const Resept& R);
};
std::ostream& operator<<(std::ostream& out, const Resept& R);


class Hvitresept : Resept {
 public:
  Hvitresept(const std::shared_ptr<Legemiddel> &legemiddel,
	     const std::shared_ptr<Lege> &lege, int n1, int n2); 

  friend std::ostream& operator<<(std::ostream& out, const Hvitresept& H);
};
std::ostream& operator<<(std::ostream& out, const Hvitresept& H);

#endif
