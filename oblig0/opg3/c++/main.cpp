#include "Bil3.h"
#include "Person.h"
#include <iostream>

int main() {
  Bil3 *bilen = new Bil3("123");
  Person *personen = new Person(bilen);
  
  personen->skrivBilNummer();
  
  return 0;
}
