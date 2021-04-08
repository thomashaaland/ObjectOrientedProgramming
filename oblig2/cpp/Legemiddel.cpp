#include "Legemiddel.h"

Legemiddel::Legemiddel(const char* navn, double pris, double virkestoff) {}

Narkotisk::Narkotisk(const char* navn, double pris, double virkestoff, int styrke)
  : Legemiddel{ navn, pris, virkestoff }
{}
