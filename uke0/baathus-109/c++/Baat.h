#ifndef BAAT_H
#define BAAT_H
#include <string>

using String = std::string;

class Baat {
 private:
  static int m_antProd;
  int m_prodnr;
  const char* m_navn;
 public:
  Baat(const char*);
  ~Baat();
  String hentInfo();
};

#endif
