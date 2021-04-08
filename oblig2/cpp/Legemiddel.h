#ifndef LEGEMIDDEL_H
#define LEGEMIDDEL_H

class Legemiddel {
 public:
  Legemiddel(const char* navn, double pris, double virkestoff);
};

class Narkotisk: public Legemiddel {
 public:
  Narkotisk(const char* navn, double pris, double virkestoff, int styrke);
};

#endif
