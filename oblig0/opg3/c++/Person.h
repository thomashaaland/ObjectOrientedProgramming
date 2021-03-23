#ifndef PERSON_H
#define PERSON_H

#include "Bil3.h"

class Person {
 private:
  Bil3 *bil;

 public:
  Person(Bil3*);
  ~Person();
  void skrivBilNummer();
};

#endif
