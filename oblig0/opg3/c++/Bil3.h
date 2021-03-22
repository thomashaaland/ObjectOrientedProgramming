#ifndef BIL3_H
#define BIL3_H
#include <string>

class Bil3 {
 private:
  std::string bilnummer;

 public:
  Bil3(std::string);
  std::string hentNummer();
};

#endif
