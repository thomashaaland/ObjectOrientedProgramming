#ifndef BAATHUS_H
#define BAATHUS_H
#include "Baat.h"
#include <vector>

class BaatHus {
 private:
  int m_kapasitet;
  int m_nBaater;
  std::vector<Baat> baater;
 public:
  BaatHus(int);
  ~BaatHus();

  void settInn(const char*);
  void skrivBaater();
};

#endif
