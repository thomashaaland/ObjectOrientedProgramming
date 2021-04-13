#ifndef LEGE_H
#define LEGE_H

#include <ostream>

class Lege {
 private:
  const char* m_navn;
 public:
  Lege(const char* navn);
  const char* hentNavn() const;

  friend std::ostream& operator<<(std::ostream& out, const Lege& L);
};

std::ostream& operator<<(std::ostream& out, const Lege& L);

#endif
