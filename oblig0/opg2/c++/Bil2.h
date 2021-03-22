#ifndef BIL2_H
#define BIL2_H

#include <string>

class Bil2 {
 private:
  std::string bilnummer;

 public:
  Bil2(std::string);
  void skrivBilInfo();
};

#endif
