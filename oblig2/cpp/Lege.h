#ifndef LEGE_H
#define LEGE_H

#include <ostream>

class Lege {
public:
  Lege(const char* navn);
  const char* hentNavn() const;
  
  friend std::ostream& operator<<(std::ostream& out, const Lege& L);

private:
  const char* m_navn;

};

std::ostream& operator<<(std::ostream& out, const Lege& L);


class Godkjenningsfritak {
public:
  virtual int hentKontrollID() = 0;
};


class Spesialist : public Lege, public Godkjenningsfritak {
public:
  Spesialist(const char* name, int kontrollID);
  int hentKontrollID() override;

  friend std::ostream& operator<<(std::ostream& out, const Spesialist& S);
  
private:
  int m_kontrollID;
};

#endif
