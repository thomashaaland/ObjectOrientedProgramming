#ifndef BIL_H
#define BIL_H

class Bil {
 private:
  const char* m_navn, * m_bilmerke;
 public:
  Bil(const char*, const char*);
  void skrivInfo();
};

#endif
