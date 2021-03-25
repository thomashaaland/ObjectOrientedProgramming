#ifndef PERSON_H
#define PERSON_H
#include <string>

using String = std::string;

class Person {
 private:
  String m_navn, m_telefonNummer, m_adresse;
 public:
  Person(String, String, String);
  String hentNavn();
  void skrivInfo();
  
};

#endif
