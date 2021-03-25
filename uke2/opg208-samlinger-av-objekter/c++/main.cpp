#include "Person.h"
#include <iostream>
#include <unordered_map>

int main() {
  Person p1("Anne", "22344556", "Loveien 1");
  Person p2("Nils", "22324354", "Yralle 0");
  Person p3("Arne", "93847575", "Tafattveien 7");
  Person p4("Anne", "92837465", "Lesesal 1");

  // For å ha Person instances på stacken for deretter å sette inn adressen
  // til en Person instance. Map inneholder da pekere til Person instances.
  std::unordered_map<String, Person*> telefonBok;

  telefonBok[p1.hentNavn()] = &p1;
  telefonBok[p2.hentNavn()] = &p2;
  telefonBok[p3.hentNavn()] = &p3;
  telefonBok[p4.hentNavn()] = &p4;

  for (const std::pair<String, Person*>& entry : telefonBok) {
    entry.second->skrivInfo();
  }

  // For aa ha Person instances direkte i containeren må vi bruke insert:
  std::unordered_map<String, Person> telefonBok2;
  telefonBok2.insert( std::unordered_map< String, Person >::value_type
		      ("Anne", Person("Anne", "22344556", "Loveien 1") ) );
  for (const std::pair<String, Person>& entry : telefonBok2) {
    telefonBok2.find(entry.first)->second.skrivInfo();
  }
  
  return 0;
}
